package com.example.mytasks.implicits

import com.example.mytasks.models.User
import io.circe._



object http {

//  implicit val usernameEncoder: Encoder[User] = Encoder.instance {
//    x => Json.fromString(x.value)
//  }

  implicit val encodeUser: Encoder[User] =
    Encoder.forProduct2("id", "name")(u => (u.id, u.name))

//  implicit val userEncoder: Encoder[User] = deriveEncoder[User]

}
