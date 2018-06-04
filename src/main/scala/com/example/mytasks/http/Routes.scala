package com.example.mytasks.http

import cats.effect.Effect
import cats.syntax.functor._
import cats.syntax.flatMap._
import com.example.mytasks.modules.Workflow
import io.circe.syntax._
import org.http4s.{HttpService, Response}
import org.http4s.dsl.Http4sDsl
import org.http4s.circe._
import com.example.mytasks.implicits.http._


class Routes[F[_]: Effect] extends Http4sDsl[F] {

  val service: HttpService[F] = HttpService[F] {

    case GET -> Root  => Ok("Hola")

  }

}