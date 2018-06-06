package com.example.mytasks.interpreters.db

import cats.effect.Async
import com.example.mytasks.algebras.Users
import com.example.mytasks.models.User
import doobie.h2.H2Transactor
import doobie.implicits._
import doobie.util.query.Query0
import doobie.util.update.Update0

class UsersInterpreter[F[_]: Async](implicit TA: F[H2Transactor[F]]) extends Users[F] {

  override def add(name: String): F[Int] = runQuery[F, Int](UsersQueries.addUser(name).withUniqueGeneratedKeys[Int]("id"))

  override def list: F[List[User]] = runQuery[F, List[User]](UsersQueries.listUsers.to[List])
}

object UsersQueries {

  def listUsers: Query0[User] = sql"SELECT * FROM users".query[User]

  def addUser(name: String): Update0 = sql"insert into users (name) values($name)".update
}
