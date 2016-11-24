name := "scala-cloudwatch-metrics"

organization := "com.gu"

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

scalaVersion := "2.11.4"

crossScalaVersions := Seq("2.10.4", "2.11.4")

val awsLibVersion = "1.10.69"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "com.amazonaws" % "aws-java-sdk-cloudwatch" % awsLibVersion,
  "org.scalaz.stream" %% "scalaz-stream" % "0.6",
  "org.slf4j" % "slf4j-api" % "1.7.5",
  "org.slf4j" % "slf4j-simple" % "1.7.5"
)

bintraySettings

com.typesafe.sbt.SbtGit.versionWithGit
