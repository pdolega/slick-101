package com.slick101.test

import org.flywaydb.core.Flyway
import slick.driver.H2Driver.api._

trait DbInstance {
  val db: Database
}

trait MemDb extends DbInstance {
  lazy val db = Database.forConfig("memoryDb")
}

trait ServerDb extends DbInstance {
  lazy val db = dbHandle

  private def dbHandle = {
    val config = TestEnv.config.getConfig("fileDb")

    val flyway = new Flyway
    flyway.setDataSource(config.getString("url"), config.getString("user"), config.getString("password"))
    flyway.migrate()

    Database.forConfig("fileDb")
  }
}
