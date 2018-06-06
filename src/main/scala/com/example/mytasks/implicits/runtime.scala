package com.example.mytasks.implicits

import cats.Applicative
import cats.effect.{Async, IO}
import com.example.mytasks.Database
import com.example.mytasks.algebras._
import com.example.mytasks.config.{AppConfig, AppConfigBuilder}
import com.example.mytasks.interpreters.db.{TasksInterpreter => DBTasksInterpreter, UsersInterpreter => DBUsersInterpreter}
import com.example.mytasks.interpreters.memory.{TasksInterpreter, UsersInterpreter}
import com.example.mytasks.modules.Workflow
import doobie.h2.H2Transactor

object runtime {

  object memory {

    implicit def users[F[_] : Applicative]: Users[F] = new UsersInterpreter[F]

    implicit def tasks[F[_] : Applicative]: Tasks[F] = new TasksInterpreter[F]

    implicit def workflow[F[_] : Applicative](implicit U: Users[F], T: Tasks[F]): Workflow[F] =
      Workflow.impl[F](U, T)
  }

  object db {

    implicit def appConfig[F[_]: Async]: F[AppConfig] = new AppConfigBuilder[F].build

    implicit val ioAppConfig: IO[AppConfig] = appConfig[IO]

    implicit def transactor[F[_]: Async]: F[H2Transactor[F]] = new Database[F].buildTransactor

    implicit def users[F[_]: Async](implicit TA: F[H2Transactor[F]]): Users[F] = new DBUsersInterpreter[F]

    implicit def tasks[F[_]: Async](implicit TA: F[H2Transactor[F]]): Tasks[F] = new DBTasksInterpreter[F]

    implicit def workflow[F[_]: Async](implicit U: Users[F], T: Tasks[F]): Workflow[F] =
      Workflow.impl[F](U, T)
  }
}
