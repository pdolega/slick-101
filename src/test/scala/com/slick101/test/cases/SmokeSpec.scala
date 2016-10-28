package com.slick101.test.cases

import com.slick101.test.{BaseTest, TestEnv}
import slick.jdbc.H2Profile.api._

import scala.concurrent.ExecutionContext.Implicits.global

class SmokeSpec extends BaseTest {
  "Smoke tests" must {
    "correctly read configuration" in {
      val driverClass = TestEnv.config.getString("slick101db.driver")
      driverClass shouldBe "org.h2.Driver"
    }

    "correctly open db" in {
      val db = Database.forConfig("slick101db")
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
