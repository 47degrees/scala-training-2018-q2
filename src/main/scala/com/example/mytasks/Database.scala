package com.example.mytasks

import cats.effect.Async
import doobie.h2.H2Transactor
import org.flywaydb.core.Flyway

class Database[F[_]: Async] {

  def buildTransactor: F[H2Transactor[F]] = {
    H2Transactor.newH2Transactor[F](Database.dbUrl, Database.dbUser, Database.dbPass)
  }
}

object Database {
  private val dbUrl   = "jdbc:h2:mem:mytasks;MODE=PostgreSQL;DB_CLOSE_DELAY=-1"
  private val dbUser  = "sa"
  private val dbPass  = ""

  def migrateDB[F[_]: Async]: F[Int] =
    Async[F].pure {
      val flyway = new Flyway
      flyway.setDataSource(dbUrl, dbUser, dbPass)
      flyway.migrate()
    }
}