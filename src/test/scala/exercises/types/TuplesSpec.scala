package exercises.types

import java.util.Date

import org.scalatest._

class TuplesSpec extends FlatSpec with Matchers {

  "Tuples" should "be equal although have been instantiated differently" in {

    val t1 = (1, "hello", Console)
    val t2 = new Tuple3(1, "hello", Console)

    (t1 == t2) shouldBe true


  }

  it should "be of mixed type" in {

    val tuple5 = ("a", 1, 2.2, new Date(), "five")

    tuple5._2 shouldBe 1
    tuple5._5 shouldBe "five"


  }


  it should "can assign multiple variables at once using tuples" in {

    val student = ("Sean Rogers", 21, 3.5)
    val (name, age, gpa) = student

    name should be("Sean Rogers")
    age should be(21)
    gpa should be(3.5)


  }



}
