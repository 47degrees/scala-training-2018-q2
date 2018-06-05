package com.example.mytasks.models


case class AddUserRequest(name: String)
case class AddUserResponse(id: Int)

case class AddTaskRequest(title: String)
case class AddTaskResponse(id: Int)
