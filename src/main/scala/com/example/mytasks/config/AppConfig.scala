package com.example.mytasks.config

import cats.effect.Async
import pureconfig.loadConfig

case class AppConfig(database: DatabaseConfig, http: HttpConfig)

case class DatabaseConfig(name: String, user: String, password: String)

case class HttpConfig(host: String, port: Int)

class AppConfigBuilder[F[_]: Async] {
  def build: F[AppConfig] =
    loadConfig[AppConfig].fold(
      errors => Async[F].raiseError(new RuntimeException(errors.toList.map(_.description).mkString(","))),
      config => Async[F].pure(config)
    )
}
