import sbt._

object Dependencies {
  val Http4sVersion = "0.18.12"
  lazy val logback = "ch.qos.logback"  %  "logback-classic" % "1.2.3"
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
  lazy val http4s = Seq(
    "org.http4s"      %% "http4s-blaze-server" % Http4sVersion,
    "org.http4s"      %% "http4s-circe"        % Http4sVersion,
    "org.http4s"      %% "http4s-dsl"          % Http4sVersion)

  lazy val dependencies: Seq[ModuleID] = Seq(
    logback,
    scalaTest % Test
  ) ++ http4s

}
