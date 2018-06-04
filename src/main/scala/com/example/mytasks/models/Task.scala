package com.example.mytasks.models

case class Task(id: Int, userId: Int, title: String, done: Boolean = false)
