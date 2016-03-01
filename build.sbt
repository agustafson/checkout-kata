organization := "com.supermarket"

name := "checkout-kata"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "3.7" % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.0" % "test"
)

coverageEnabled := true
coverageMinimum := 80
coverageFailOnMinimum := true
