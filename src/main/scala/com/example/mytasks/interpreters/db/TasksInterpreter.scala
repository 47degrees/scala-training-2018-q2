package com.example.mytasks.interpreters.db

import cats.effect.Async
import cats.implicits._
import com.example.mytasks.algebras.Tasks
import com.example.mytasks.models.Task
import doobie.h2.H2Transactor
import doobie.implicits._
import doobie.util.query.Query0
import doobie.util.update.Update0

class TasksInterpreter[F[_]: Async](implicit TA: F[H2Transactor[F]]) extends Tasks[F]{

  override def add(userId: Int, title: String): F[Int] = runQuery[F, Int](TasksQueries.addUser(userId, title).withUniqueGeneratedKeys[Int]("id"))

  override def list(userId: Int): F[List[Task]] = runQuery[F, List[Task]](TasksQueries.listTasks(userId).to[List])

  override def asDone(id: Int): F[Boolean] = runQuery[F, Int](TasksQueries.asDone(id).run).map(_ > 0)
}

object TasksQueries {

  def listTasks(userId: Int): Query0[Task] = sql"SELECT * FROM tasks where userId=$userId".query[Task]

  def addUser(userId: Int, title: String): Update0 = sql"insert into tasks (userId,title) values($userId,$title)".update

  def asDone(id: Int): Update0 = sql"update tasks set done=true where id=$id".update
}
