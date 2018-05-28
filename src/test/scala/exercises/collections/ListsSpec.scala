package exercises.collections

import org.scalatest._

class ListsSpec extends FlatSpec with Matchers {

  "List" should "have the method eq to check the same object" in {

    val a = List(1, 2, 3)
    val b = List(1, 2, 3)
    (a eq b) should be(false)
  }

  it should "have the method eq to check the same content" in {

    val a = List(1, 2, 3)
    val b = List(1, 2, 3)
    (a equals b) should be(true)
  }

  it should "have identical representation of Nil" in {

    val a: List[String] = Nil
    val b: List[Int] = Nil

    (a == Nil) should be(true)
    (a eq Nil) should be(true)

    (b == Nil) should be(true)
    (b eq Nil) should be(true)

    (a == b) should be(true)
    (a eq b) should be(true)
  }

  it should "be acceded via head and tail" in {

    val a = List(1, 2, 3)
    a.headOption should equal(Some(1))
    a.tail should equal(List(2, 3))

  }

  it should "be acceded by possition" in {

    val a = List(1, 3, 5, 7, 9)
    a(0) should equal(1)
    a(2) should equal(5)
    a(4) should equal(9)

    intercept[IndexOutOfBoundsException] {
      println(a(5))
    }

  }

  it should "be inmutable" in {

    val a = List(1, 3, 5, 7, 9)
    val b = a.filterNot(v => v == 5) // remove where value is 5

    a should equal(List(1, 3, 5, 7, 9))
    b should equal(List(1, 3, 7, 9))

  }


  it should "have several useful methods" in {

    val a = List(1, 3, 5, 7, 9)

    // get the length of the list
    a.length should equal(5)

    // reverse the list
    a.reverse should equal(List(9, 7, 5, 3, 1))

    // map a function to double the numbers over the list
    a.map { v ⇒
      v * 2
    } should equal(List(2, 6, 10, 14, 18))

    // filter any values divisible by 3 in the list
    a.filter { v ⇒
      v % 3 == 0
    } should equal(List(3, 9))

  }

  it should "have functions over lists can use _ as shorthand" in {

    val a = List(1, 2, 3)

    a.map { _ * 2 } should equal(List(2, 4, 6))

    a.filter { _ % 2 == 0} should equal(List(2))

  }

  it should "be reduced with a mathematical operation" in {

    val a = List(1, 3, 5, 7)
    a.reduceLeft(_ + _) should equal(16)
    a.reduceLeft(_ * _) should equal(105)

  }


  it should "be created from a range" in {

    val a = (1 to 5).toList
    a should be(List(1, 2, 3, 4, 5))

  }

  it should "prepend elements to get a new list" in {

    val a = List(1, 3, 5, 7)

    0 :: a shouldBe List(0, 1, 3, 5, 7)

  }

  it should "be concatenated" in {

    val head = List(1, 3)
    val tail = List(5, 7)

    head ::: tail shouldBe List(1, 3, 5, 7)
    head ::: Nil shouldBe List(1, 3)

  }




}
