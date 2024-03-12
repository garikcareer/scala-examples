ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.4.0"

lazy val helloworld = project
  .in(file("HelloWorld"))
  .settings(
    name := "HelloWorld",
    Compile / mainClass := Some("helloworld.HelloWorld"),
  )

lazy val crud = project
  .in(file("CRUD"))
  .settings(
    name := "CRUD",
    Compile / mainClass := Some("databaseaccess.CRUD"),
    libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.33"
  )
