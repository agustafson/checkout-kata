organization := "com.supermarket"

name := "checkout-kata"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.7"

libraryDependencies ++= {
  val specs2Version = "3.7.1"
  Seq(
    "org.specs2" %% "specs2-core" % specs2Version % "test",
    "org.specs2" %% "specs2-scalacheck" % specs2Version % "test",
    "org.scalacheck" %% "scalacheck" % "1.13.0" % "test"
  )
}

coverageEnabled := true
coverageMinimum := 80
coverageFailOnMinimum := true
