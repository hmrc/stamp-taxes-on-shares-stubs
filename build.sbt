name := """stamp-taxes-on-shares-stubs"""
organization := "uk.gov.hmrc"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "3.3.5"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.1" % Test

// Force Play dev-mode server (`sbt run`) to use the same port as application.conf.
PlayKeys.playDefaultPort := 30038

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "uk.gov.hmrc.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "uk.gov.hmrc.binders._"
