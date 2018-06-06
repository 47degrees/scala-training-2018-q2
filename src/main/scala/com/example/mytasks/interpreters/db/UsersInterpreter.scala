package com.example.mytasks.interpreters.db

import cats.effect.Async
import com.example.mytasks.algebras.Users
import com.example.mytasks.models.User
import doobie.free.connection.ConnectionIO
import doobie.h2.H2Transactor
import doobie.implicits._
import doobie.util.query.Query0
import doobie.util.update.Update0

class UsersInterpreter[F[_]: Async](implicit TA: F[H2Transactor[F]]) extends Users[F] {

  private[this] def runQuery[A](query: ConnectionIO[A]) = Async[F].flatMap(TA)(xa => query.transact(xa))

  override def add(name: String): F[Int] = runQuery(UsersQueries.addUser(name).withUniqueGeneratedKeys[Int]("id"))

  override def list: F[List[User]] = runQuery(UsersQueries.listUsers.to[List])
}

object UsersQueries {

  def listUsers: Query0[User] = sql"SELECT * FROM users".query[User]

  def addUser(name: String): Update0 = sql"insert into users (name) values($name)".update
}
