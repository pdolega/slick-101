package com.slick101.test.cases.conversation

import java.util.UUID

import slick.driver.H2Driver.api._

case class Id[T](value: Long)

object Id {
  def none[T]: Id[T] = Id[T](-1L)
}

object TypesafeId {
  implicit def columnType[T]: BaseColumnType[Id[T]] =
    MappedColumnType.base[Id[T], Long](toLong, fromLong)

  private def fromLong[T](dbId: Long): Id[T] = Id(dbId)

  private def toLong[T](id: Id[T]): Long = id.value


  implicit def columnTypeUUID: BaseColumnType[UUID] =
    MappedColumnType.base[UUID, String](toString, fromString)

  private def fromString(dbId: String): UUID = UUID.fromString(dbId)

  private def toString(id: UUID): String = id.toString
}
