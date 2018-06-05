package com.example.mytasks.algebras

import com.example.mytasks.models.User

abstract class Users[F[_]] {

  def add(name: String): F[Int]

  def list: F[List[User]]

}
