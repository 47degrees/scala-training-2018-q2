package com.example.mytasks.modules

import cats.Id
import com.example.mytasks.algebras._
import com.example.mytasks.models._
import com.example.mytasks.utils.ArbitraryInstances
import org.scalatest._
import org.scalamock.scalatest.MockFactory
import org.scalatest.prop.Checkers
import org.scalacheck.Prop.forAll

class WorkflowSpec extends FlatSpec
  with Matchers
  with Checkers
  with MockFactory
  with OneInstancePerTest
  with ArbitraryInstances {

  val users: Users[Id] = stub[Users[Id]]
  val tasks: Tasks[Id] = stub[Tasks[Id]]

  val module: Workflow[Id] = Workflow.impl[Id](users, tasks)


  "Workflow" should "be able to add new users" in {

    check {
      forAll(userGen) { user =>
        val expected = user.id
        (users.add _).when(user.name).returns(expected)

        module.addUser(user.name) === expected
      }
    }
  }

  it should "be able to retrieve the list of users" in {

    val userList: List[User] = listUserGen.sample.get
    (users.list _).when().returns(userList)
    module.getUsers shouldBe userList

  }

  it should "be able to add new tasks" in {

    check {
      forAll(taskGen) { task =>
        val expected = task.id
        (tasks.add _).when(task.userId, task.title).returns(expected)
        module.addTask(task.userId, task.title) === expected
      }
    }
  }


  it should "be able to retrieve the list of tasks" in {

    val taskList: List[Task] = listTaskGen.sample.get
    check {
      forAll(userGen) { user =>

        (tasks.list _).when(user.id).returns(taskList)
        module.getTasks(user.id) === taskList
      }
    }
  }


  it should "be able to set a task as done" in {
    check {
      forAll(taskGen) { task =>
        (tasks.asDone _).when(task.id).returns(true)
        module.asDone(task.id) === true
      }
    }
  }

}
