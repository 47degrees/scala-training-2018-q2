package com.example.mytasks

import cats.effect.{Effect, IO}
import com.example.mytasks.http.Routes
import com.example.mytasks.implicits.runtime._
import fs2.StreamApp
import org.http4s.server.blaze.BlazeBuilder

import scala.concurrent.ExecutionContext.Implicits.global

object Server extends HttpServer[IO]

class HttpServer[F[_]: Effect] extends StreamApp[F] {

  def service[F[_]: Effect] = new Routes[F].service

  override def stream(args: List[String], requestShutdown: F[Unit]) =
    BlazeBuilder[F]
    .bindHttp()
    .mountService(service, "/")
    .serve


}