package com.example.mytasks

import cats.effect.{Effect, IO}
import com.example.mytasks.config.AppConfig
import com.example.mytasks.http.Routes
import com.example.mytasks.implicits.runtime.db._
import fs2.StreamApp
import org.http4s.server.blaze.BlazeBuilder

import scala.concurrent.ExecutionContext.Implicits.global

object Server extends HttpServer[IO]

class HttpServer[F[_]: Effect](implicit C: F[AppConfig]) extends StreamApp[F] {

  def service[F[_]: Effect] = new Routes[F].service

  override def stream(args: List[String], requestShutdown: F[Unit]): fs2.Stream[F, StreamApp.ExitCode] =
    for {
      config <- fs2.Stream.eval(C)
      _ <- fs2.Stream.eval(Database.migrateDB(config))
      httpServer <- BlazeBuilder[F]
        .bindHttp(config.http.port, config.http.host)
        .mountService(service, "/")
        .serve
    } yield httpServer
}