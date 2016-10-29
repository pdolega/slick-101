package com.slick101.test.cases.table

import com.slick101.test.{BaseTest, MemDb}
import org.scalatest.BeforeAndAfterEach
import slick.jdbc.H2Profile.api._

class TableSpec extends BaseTest with BeforeAndAfterEach with MemDb {

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
    blockingWait(db.run(UniversityTable.schema.create))
  }

  // tear down schema
  override protected def afterEach {
    blockingWait(db.run(UniversityTable.schema.drop))
  }

  // tests
  "Universities" must {
    // this is bad - we'll get to it later
    "be insertable and retrievable - poor version" in {
      blockingWait(db.run(UniversityTable.result)) should have size 0
      blockingWait(db.run(
        UniversityTable ++= Seq(
          University("Hogwart"),
          University("Scala University")
        )
      ))

      val results = blockingWait(db.run(UniversityTable.result))
      results.foreach(u => log.debug(s"${u}"))
      results.map(_.name) should contain theSameElementsAs
        Seq("Hogwart", "Scala University")
    }
  }
}
