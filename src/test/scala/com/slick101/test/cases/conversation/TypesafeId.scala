package com.slick101.test.cases.conversation

import slick.jdbc.H2Profile.api._

case class Id[T](value: Long)

object Id {
  def none[T]: Id[T] = Id[T](-1L)
}

object TypesafeId {
  implicit def columnType[T]: BaseColumnType[Id[T]] =
    MappedColumnType.base[Id[T], Long](toLong, fromLong)

  private def fromLong[T](dbId: Long): Id[T] = Id(dbId)

  private def toLong[T](id: Id[T]): Long = id.value
}
