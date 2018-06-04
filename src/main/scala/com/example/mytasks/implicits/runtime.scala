package com.example.mytasks.implicits

import cats.Applicative
import com.example.mytasks.algebras._
import com.example.mytasks.interpreters._
import com.example.mytasks.modules.Workflow

object runtime {

  implicit def users[F[_]: Applicative]: Users[F] = new UsersInterpreter[F]

  implicit def tasks[F[_]: Applicative]: Tasks[F] = new TasksInterpreter[F]

  implicit def workflow[F[_]: Applicative](implicit U: Users[F], T: Tasks[F]): Workflow[F] =
    Workflow.impl[F](U, T)

}
