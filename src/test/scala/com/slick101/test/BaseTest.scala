package com.slick101.test

import com.typesafe.config.ConfigFactory
import com.typesafe.scalalogging.Logger
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Millis, Span}
import org.scalatest.{BeforeAndAfterAll, Matchers, TestSuite, WordSpecLike}
import slick.jdbc.H2Profile.api._

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.DurationLong

trait BaseTest extends TestSuite with BeforeAndAfterAll with WordSpecLike with Matchers with ScalaFutures {

  implicit val config = generateTimeoutConfig

  lazy val memDb = TestEnv.db

  val log = Logger(getClass)

  protected def blockingWait[T](f: Future[T]) = Await.result(f, config.timeout.totalNanos.nanos)

  override protected def beforeAll() = {
    super.beforeAll()
    TestEnv.initialize
  }

  private def generateTimeoutConfig = {
    val timeout = TestEnv.config.getLong("timeouts.timeout")
    val interval = TestEnv.config.getLong("timeouts.interval")
    PatienceConfig(timeout = scaled(Span(timeout, Millis)), interval = scaled(Span(interval, Millis)))
  }
}

object TestEnv {
  lazy val config = ConfigFactory.load("application.conf")

  lazy val db = Database.forConfig("slick101db")

  lazy val initialize = performInitialize

  private def performInitialize = {
    true
  }
}