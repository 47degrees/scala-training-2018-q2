package com.example.mytasks.interpreters.memory

import cats.Applicative
import cats.implicits._
import com.example.mytasks.algebras.Users
import com.example.mytasks.models.User

class UsersInterpreter[F[_]: Applicative] extends Users[F] {

  var db: List[User] = Nil

  override def add(name: String): F[Int] = {
    val newId: Int = getNextId
    db = db ++ List(User(newId, name))
    newId.pure[F]
  }

  override def list: F[List[User]] = db.pure[F]

  private def getNextId: Int = db.lastOption.fold(1)(_.id + 1)

}
