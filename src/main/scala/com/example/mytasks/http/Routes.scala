package com.example.mytasks.http

import cats.effect.Effect
import cats.syntax.flatMap._
import cats.syntax.functor._
import com.example.mytasks.implicits.http._
import com.example.mytasks.models._
import com.example.mytasks.modules.Workflow
import io.circe.Decoder
import io.circe.syntax._
import org.http4s.{EntityDecoder, HttpService}
import org.http4s.circe._
import org.http4s.dsl.Http4sDsl


class Routes[F[_] : Effect](implicit wf: Workflow[F]) extends Http4sDsl[F] {

  implicit def entityDecoder[A: Decoder]: EntityDecoder[F, A] = jsonOf[F, A]

  val service: HttpService[F] = HttpService[F] {

    case GET -> Root / "users" =>
      wf.getUsers.map(l => Ok(l.asJson)).flatten

    case req@POST -> Root / "users" =>
      req.decode[AddUserRequest] { u =>
        wf.addUser(u.name).map(id => Ok(AddUserResponse(id).asJson)).flatten
      }

    case GET -> Root / "tasks" / IntVar(userId) =>
      wf.getTasks(userId).map(l => Ok(l.asJson)).flatten

    case req@POST -> Root / "tasks" / IntVar(userId) => req.decode[AddTaskRequest] { u =>
      wf.addTask(userId.toInt, u.title).map(id => Ok(AddTaskResponse(id).asJson)).flatten
    }

    case PUT -> Root / "tasks" / IntVar(id) =>
      wf.asDone(id).map{
        case true => Ok()
        case false => NotFound("Task not found")
      }.flatten

  }

}