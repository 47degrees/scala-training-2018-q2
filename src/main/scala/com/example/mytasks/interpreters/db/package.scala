package com.example.mytasks.interpreters

import cats.effect.Async
import doobie.free.connection.ConnectionIO
import doobie.implicits._
import doobie.h2.H2Transactor

package object db {
  def runQuery[F[_]: Async, A](query: ConnectionIO[A])(implicit TA: F[H2Transactor[F]]): F[A] =
    Async[F].flatMap(TA)(xa => query.transact(xa))
}
