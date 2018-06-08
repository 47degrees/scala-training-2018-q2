package com.example.mytasks.modules

import cats.Id
import com.example.mytasks.algebras._
import com.example.mytasks.models._
import org.scalatest._
import org.scalamock.scalatest.MockFactory

class WorkflowSpec extends FlatSpec with Matchers with MockFactory {

  val user1 = User(1, "Rafa")
  val task1 = Task(1, user1.id, "Kakuro challenge")

  val users: Users[Id] = stub[Users[Id]]
  val tasks: Tasks[Id] = stub[Tasks[Id]]

  val module: Workflow[Id] = Workflow.impl[Id](users, tasks)


  "Workflow" should "be able to add new users" in {
    val expected = user1.id
    (users.add _).when(*).returns(expected)

    module.addUser(user1.name) shouldBe expected
  }

  it should "be able to retrieve the list of users" in {
    val expected = List(user1)
    (users.list _).when().returns(expected)

    module.getUsers shouldBe expected
  }

  it should "be able to add new tasks" in {
    val expected = task1.id
    (tasks.add _).when(*, *).returns(expected)

    module.addTask(user1.id, task1.title) shouldBe expected
  }

  it should "be able to retrieve the list of tasks" in {
    val expected = List(task1)
    (tasks.list _).when(*).returns(expected)

    module.getTasks(user1.id) shouldBe expected
  }

  it should "be able to set a task as done" in {
    val expected = true
    (tasks.asDone _).when(*).returns(expected)

    module.asDone(task1.id) shouldBe expected
  }



}
