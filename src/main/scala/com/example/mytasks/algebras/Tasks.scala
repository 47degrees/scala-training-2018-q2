package com.example.mytasks.algebras

import com.example.mytasks.models.Task

abstract class Tasks[F[_]] {

  def add(userId: Int, title: String): F[Int]

  def list(userId: Int): F[List[Task]]

  def asDone(id: Int): F[Boolean]

}
