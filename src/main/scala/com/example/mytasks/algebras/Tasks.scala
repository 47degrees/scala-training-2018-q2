package com.example.mytasks.algebras

import com.example.mytasks.models.Task

abstract class Tasks[F[_]] {

  def add(task: Task): F[Int]

  def list: F[List[Task]]

}
