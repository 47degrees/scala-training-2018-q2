package exercises.types

import exercises.types.options._
import org.scalatest._

class OptionsSpec extends FlatSpec with Matchers {

  "Option" should "be Some(a) or None" in {

    val someValue: Option[String] = Some("I am wrapped in something")
    val emptyValue: Option[String] = None

    someValue should be(Option("I am wrapped in something"))
    emptyValue should be(None)
  }

  it should "have getOrElse method" in {

    val value1 = maybeItWillReturnSomething(true)
    val value2 = maybeItWillReturnSomething(false)

    value1 getOrElse "No value" should be("Found value")
    value2 getOrElse "No value" should be("No value")
    value2 getOrElse {
      "default function"
    } should be("default function")
  }

  it should "have isEmpty method" in {

    val value1 = maybeItWillReturnSomething(true)
    val value2 = maybeItWillReturnSomething(false)

    value1.isEmpty should be(false)
    value2.isEmpty should be(true)
  }

  it should "be used with pattern matching" in {

    val someValue: Option[Double] = Some(20.0)
    val noValue: Option[Double] = None

    val value: Double = someValue match {
      case Some(v) => v
      case None => 0.0
    }

    getDouble(someValue) should be(20d)
    getDouble(noValue) should be(0)

  }

  it should "have map function" in {

    val number: Option[Int] = Some(3)
    val noNumber: Option[Int] = None
    val result1 = number.map(_ * 2)
    val result2 = noNumber.map(_ * 2)

    result1 should be(Some(6))
    result2 should be(None)

    //Get the function out
    //def twice(i: Int): Int = i * 2
    //val result1 = number.map(twice)
    //val result2 = noNumber.map(twice)

  }


  it should "have fold function" in {

    val number: Option[Int] = Some(3)
    val noNumber: Option[Int] = None
    val result1 = number.fold(1)(_ * 3)
    val result2 = noNumber.fold(1)(_ * 3)

    result1 should be(9)
    result2 should be(1)

  }



}
