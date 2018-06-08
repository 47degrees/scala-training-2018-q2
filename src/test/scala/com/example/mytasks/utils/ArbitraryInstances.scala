package com.example.mytasks.utils

import com.example.mytasks.models.{Task, User}
import org.scalacheck.Arbitrary.arbitrary
import org.scalacheck.Gen

trait ArbitraryInstances {

  val userGen: Gen[User] = for {
    id <- arbitrary[Int]
    name <- Gen.alphaStr
  } yield User(id, name)

  val listUserGen: Gen[List[User]] = Gen.listOfN(10, userGen)


  val taskGen: Gen[Task] = for {
    id <- arbitrary[Int]
    user <- userGen
    title <- Gen.alphaStr
  } yield Task(id, user.id, title)

  val listTaskGen: Gen[List[Task]] = Gen.listOfN(10, taskGen)

}
