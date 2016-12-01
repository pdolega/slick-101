package com.slick101.test.cases.smoke

import com.slick101.test.{BaseTest, MemDb, TestEnv}
import slick.driver.H2Driver.api._

import scala.concurrent.ExecutionContext.Implicits.global

class SmokeSpec extends BaseTest with MemDb {
  "Smoke tests" must {
    "correctly read configuration" in {
      val driverClass = TestEnv.config.getString("memoryDb.driver")
      driverClass shouldBe "org.h2.Driver"
    }

    "correctly open db" in {
      val db = Database.forConfig("memoryDb")
      val results = db.run(sql"SELECT 2 + 3".as[(Int)])

      // option 1 - bad
      blockingWait(results).head shouldBe 5

      // option 2 - better
      results.map { r =>
        r.head shouldBe (5)
      }.futureValue
    }
  }
}
