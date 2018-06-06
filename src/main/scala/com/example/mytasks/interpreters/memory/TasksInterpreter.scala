package com.example.mytasks.interpreters.memory

import cats.Applicative
import cats.implicits._
import com.example.mytasks.algebras.Tasks
import com.example.mytasks.models.Task

class TasksInterpreter[F[_]: Applicative] extends Tasks[F]{

  var db: List[Task] = Nil

  override def add(userId: Int, title: String): F[Int] = {
    val newId: Int = getNextId
    db = db ++ List(Task(newId, userId, title))
    newId.pure[F]
  }

  override def list(userId: Int): F[List[Task]] = db.filter(_.userId == userId).pure[F]

  override def asDone(id: Int): F[Boolean] = find(id).fold(false){ t =>
    db = db.filterNot(_ == t) ++ List(asTrue(t))
    true
  }.pure[F]


  private def getNextId: Int = db.lastOption.fold(1)(_.id + 1)

  private def find(id: Int): Option[Task] = db.find(_.id == id)

  private def asTrue(t: Task): Task = t.copy(done = true)


}
