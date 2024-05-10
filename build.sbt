import Dependencies.*

ThisBuild / scalaVersion     := "3.3.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "dopenkov"
ThisBuild / organizationName := "Dmitrii Openkov"

lazy val root = (project in file("."))
  .settings(
    name := "codecontest",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += scalaTestCheck % Test
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
