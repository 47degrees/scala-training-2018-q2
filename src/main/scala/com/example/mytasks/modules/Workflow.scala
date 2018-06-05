package com.example.mytasks.modules

import com.example.mytasks.algebras._
import com.example.mytasks.models._

trait Workflow[F[_]] {

  def addUser(name: String): F[Int]

  def getUsers: F[List[User]]

  def addTask(userId: Int, title: String): F[Int]

  def getTasks(userId: Int): F[List[Task]]

  def asDone(id: Int): F[Boolean]


}

object Workflow {

  def impl[F[_]](users: Users[F], tasks: Tasks[F]): Workflow[F] = new Workflow[F] {

    override def addUser(name: String): F[Int] = users.add(name)

    override def getUsers: F[List[User]] = users.list

    override def addTask(userId: Int, title: String): F[Int] = tasks.add(userId, title)

    override def getTasks(userId: Int): F[List[Task]] = tasks.list(userId)

    override def asDone(id: Int): F[Boolean] = tasks.asDone(id)
  }

}
