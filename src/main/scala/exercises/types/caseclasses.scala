package exercises.types

object caseclasses {

  case class Dog(name: String, breed: String)

  case class Person(name: String, age: Int = 0, ssn: String = "")

}
