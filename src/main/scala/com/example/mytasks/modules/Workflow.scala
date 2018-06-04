package com.example.mytasks.modules

import com.example.mytasks.algebras._
import com.example.mytasks.models._

trait Workflow[F[_]] {

  def getUsers: F[List[User]]

  def getTasks: F[List[Task]]

  def getRandomString: F[String]

}

object Workflow {

  def impl[F[_]](users: Users[F], tasks: Tasks[F]): Workflow[F] = new Workflow[F] {

    override def getTasks: F[List[Task]] = tasks.list

    override def getUsers: F[List[User]] = users.list

    override def getRandomString: F[String] = users.getRandomString
  }

}
