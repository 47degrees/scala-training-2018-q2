package com.example.mytasks.implicits

import com.example.mytasks.models._
import io.circe._
import io.circe.generic.semiauto.deriveDecoder
import io.circe.generic.semiauto.deriveEncoder

object http {

  //Decoders
  implicit val addUserReq: Decoder[AddUserRequest] = deriveDecoder[AddUserRequest]
  implicit val addTaskReq: Decoder[AddTaskRequest] = deriveDecoder[AddTaskRequest]


  //Encoders
  implicit val encoderUser: Encoder[User] = deriveEncoder[User]
  implicit val encoderTask: Encoder[Task] = deriveEncoder[Task]
  implicit val encoderAddUserResponse: Encoder[AddUserResponse] = deriveEncoder[AddUserResponse]
  implicit val encoderAddTaskResponse: Encoder[AddTaskResponse] = deriveEncoder[AddTaskResponse]

}
