import sbt.Keys._
import sbt.Resolver

name := "slick-101"

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.0-M5"

// no more lame code
scalacOptions ++= Seq("-Xfatal-warnings", "-feature")


libraryDependencies ++= {
  Seq(
    "com.typesafe.slick" %% "slick" % "3.2.0-M1",

    "com.h2database" % "h2" % "1.4.192",

    "org.flywaydb" % "flyway-maven-plugin" % "4.0.3"
  ) ++ Seq(
    "org.scalatest" %% "scalatest" % "3.0.0" % "test"
  )
}

resolvers ++= Seq(
   Resolver.sonatypeRepo("snapshots")
)

//do not generate scaladoc in dist task
sources in (Compile,doc) := Seq.empty
publishArtifact in (Compile, packageDoc) := false

testOptions in Test += Tests.Argument("-oDF")

scalastyleConfig := baseDirectory.value / "plugins-conf" / "scalastyle-config.xml"

wartremoverErrors ++= Seq(
//  Wart.Any,
  Wart.Any2StringAdd,
  Wart.AsInstanceOf,
  Wart.EitherProjectionPartial,
  Wart.IsInstanceOf,
  Wart.ListOps,
//  Wart.NonUnitStatements,
  Wart.Null,
//  Wart.OptionPartial,
//  Wart.Product,
  Wart.Return,
//  Wart.Serializable,
//  Wart.Throw,
  Wart.TryPartial,
  Wart.While,
  Wart.Var,
  Wart.JavaConversions
)