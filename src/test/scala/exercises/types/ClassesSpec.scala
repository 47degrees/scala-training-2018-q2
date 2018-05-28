package exercises.types

import exercises.types.classes.Person
import org.scalatest._

class ClassesSpec extends FlatSpec with Matchers {

  "Person" should "provide proper summary" in {

    val rafa = new Person(name = "Rafa", age = 35)

    rafa.summary shouldEqual "Rafa is 35 years old"
  }

  it should "provide proper summary when names are not specified" in {

    val paco = new Person("Paco", 36)

    paco.summary shouldEqual "Paco is 36 years old"
  }


}
