package com.example.mytasks.interpreters

import cats.Applicative
import cats.implicits._
import com.example.mytasks.algebras.Tasks
import com.example.mytasks.models.Task

class TasksInterpreter[F[_]: Applicative] extends Tasks[F]{

  override def add(task: Task): F[Int] = 999.pure[F]

  override def list: F[List[Task]] = List(Task(999, 888, "Do homeworks", false)).pure[F]
}
