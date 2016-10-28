package com.slick101.test.cases

import com.slick101.test.BaseTest
import org.scalatest.BeforeAndAfterEach
import slick.jdbc.H2Profile.api._

class TableSpec extends BaseTest with BeforeAndAfterEach {

  // table definition

  case class University(name: String,
                        id: Long = -1L)

  class UniversityTable(tag: Tag) extends Table[University](tag, "university") {
    def name = column[String]("name")
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

    def * = (name, id) <> (University.tupled, University.unapply)
  }

  lazy val UniversityTable = TableQuery[UniversityTable]


  // creating schema
  override protected def beforeEach {
    blockingWait(memDb.run(UniversityTable.schema.create))
  }

  // tear down schema
  override protected def afterEach {
    blockingWait(memDb.run(UniversityTable.schema.drop))
  }

  // tests
  "Universities" must {
    // this is bad - we'll get to it later
    "be insertable and retrievable - poor version" in {
      blockingWait(memDb.run(UniversityTable.result)) should have size 0
      blockingWait(memDb.run(
        UniversityTable ++= Seq(
          University("Hogwart"),
          University("Scala University")
        )
      ))

      val results = blockingWait(memDb.run(UniversityTable.result))
      results.foreach(u => log.debug(s"${u}"))
      results.map(_.name) should contain theSameElementsAs
        Seq("Hogwart", "Scala University")
    }
  }
}
