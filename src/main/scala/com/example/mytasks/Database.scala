package com.example.mytasks

import cats.effect.Async
import cats.implicits._
import com.example.mytasks.config.AppConfig
import doobie.h2.H2Transactor
import org.flywaydb.core.Flyway

class Database[F[_]: Async](implicit C: F[AppConfig]) {
  def buildTransactor: F[H2Transactor[F]] = {
    C.flatMap(config =>
      H2Transactor.newH2Transactor[F](
        s"jdbc:h2:mem:${config.database.name};MODE=PostgreSQL;DB_CLOSE_DELAY=-1",
        config.database.user,
        config.database.password)
    )

  }
}

object Database {
  def migrateDB[F[_]: Async](config: AppConfig): F[Int] =
    Async[F].pure {
      val flyway = new Flyway
      flyway.setDataSource(
        s"jdbc:h2:mem:${config.database.name};MODE=PostgreSQL;DB_CLOSE_DELAY=-1",
        config.database.user,
        config.database.password)
      flyway.migrate()
    }
}