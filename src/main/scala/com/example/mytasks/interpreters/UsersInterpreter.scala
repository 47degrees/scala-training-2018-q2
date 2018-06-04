package com.example.mytasks.interpreters

import cats.Applicative
import cats.implicits._
import com.example.mytasks.algebras.Users
import com.example.mytasks.models.User

class UsersInterpreter[F[_]: Applicative] extends Users[F]{

  override def add(user: User): F[Int] = 999.pure[F]

  override def list: F[List[User]] = List(User(888, "Rafa")).pure[F]

  override def getRandomString: F[String] = "Hi Rafa".pure[F]
}
