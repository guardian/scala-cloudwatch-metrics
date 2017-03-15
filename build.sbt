name := "scala-cloudwatch-metrics"

organization := "com.gu"

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

scalaVersion := "2.12.1"

homepage := Some(url("https://github.com/guardian/scala-cloudwatch-metrics"))
licenses := Seq("Apache V2" -> url("http://www.apache.org/licenses/LICENSE-2.0.html"))

publishMavenStyle := true
scmInfo := Some(ScmInfo(
  url("https://github.com/guardian/scala-cloudwatch-metrics"),
  "scm:git:git@github.com:guardian/scala-cloudwatch-metrics.git"
))

pomExtra := {
  <scm>
    <connection>scm:git:https://github.com/guardian/scala-cloudwatch-metrics</connection>
    <developerConnection>scm:git:https://github.com/guardian/scala-cloudwatch-metrics</developerConnection>
    <tag>HEAD</tag>
    <url>https://github.com/guardian/scala-cloudwatch-metrics</url>
  </scm>
  <scm>
    <connection>scm:git:github.com/(your repository URL)</connection>
    <developerConnection>scm:git:git@github.com:(your repository URL)</developerConnection>
    <url>github.com/(your repository url)</url>
  </scm>
  <developers>
    <developer>
      <id>kenoir</id>
      <name>Robert Kenny</name>
      <url>https://github.com/kenoir</url>
    </developer>
  </developers>
}

val awsLibVersion = "1.10.69"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.0" % "test",
  "com.amazonaws" % "aws-java-sdk-cloudwatch" % awsLibVersion,
  "org.scalaz.stream" %% "scalaz-stream" % "0.8.6a",
  "org.slf4j" % "slf4j-api" % "1.7.5",
  "org.slf4j" % "slf4j-simple" % "1.7.5"
)

com.typesafe.sbt.SbtGit.versionWithGit
