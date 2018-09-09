name := "akka-message"

version := "1.0"

scalaVersion := "2.12.1"

val akkaVersion = "2.5.16"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion
  )