import sbt._

object Dependencies {

  val Http4sVersion = "0.18.12"
  val CirceVersion = "0.9.3"
  val DoobieVersion = "0.5.3"
  val FlywayVersion = "5.0.5"

  lazy val pureconfig = "com.github.pureconfig" %% "pureconfig" % "0.9.1"
  lazy val logback = "ch.qos.logback"  %  "logback-classic" % "1.2.3"
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
  lazy val scalaMock = "org.scalamock" %% "scalamock" % "4.1.0"
  lazy val scalaCheck = "org.scalacheck" %% "scalacheck" % "1.14.0"

  lazy val http4s = Seq(
    "org.http4s"      %% "http4s-blaze-server" % Http4sVersion,
    "org.http4s"      %% "http4s-circe"        % Http4sVersion,
    "org.http4s"      %% "http4s-dsl"          % Http4sVersion)

  lazy val circe = Seq(
    "io.circe" %% "circe-core" % CirceVersion,
    "io.circe" %% "circe-generic" % CirceVersion,
    "io.circe" %% "circe-parser" % CirceVersion,
    "io.circe" %% "circe-literal" % CirceVersion)

  lazy val database = Seq(
    "org.tpolecat" %% "doobie-core" % DoobieVersion,
    "org.tpolecat" %% "doobie-h2" % DoobieVersion,
    "org.tpolecat" %% "doobie-scalatest" % DoobieVersion,
    "org.flywaydb" %  "flyway-core" % FlywayVersion
  )

  lazy val dependencies: Seq[ModuleID] = Seq(
    logback,
    pureconfig,
    scalaTest % Test,
    scalaMock % Test,
    scalaCheck % Test
  ) ++ http4s ++ circe ++ database

}
