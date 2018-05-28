package exercises.types

import org.scalatest._

class LiteralsSpec extends FlatSpec with Matchers {

  "Boolean" should "be either true or false, using the true or false keyword" in {

    val a = true
    val b = false
    val c = 1 > 2
    val d = 1 < 2
    val e = a == c
    val f = b == d
    a should be(true)
    b should be(false)
    c should be(false)
    d should be(true)
    e should be(false)
    f should be(false)


  }

  "Integers" should "be created from decimals as well as hexadecimals" in {

    val a = 2
    val b = 31
    val c = 0x30F
    val e = 0
    val f = -2
    val g = -31
    val h = -0x30F
    a should be(2)
    b should be(31)
    c should be(783) //Hint: 30F = 783
    e should be(0)
    f should be(-2)
    g should be(-31)
    h should be(-783)


  }


  "Longs" should "be specified by appending an L or l at the end of the declaration" in {

    val a = 2L
    val b = 31L
    val c = 0x30FL
    val e = 0L
    val f = -2l
    val g = -31L
    val h = -0x30FL

    a should be(2L)
    b should be(31L)
    c should be(783L) //Hint: 30F = 783
    e should be(0L)
    f should be(-2l)
    g should be(-31L)
    h should be(-783L)


  }


  "Float and Double" should "be defined using a f or F suffix (float) or d or D suffix (double)" in {

    val a = 3.0
    val b = 3.00
    val c = 2.73
    val d = 3f
    val e = 3.22d
    val f = 93e-9
    val g = 93E-9
    val h = 0.0
    val i = 9.23E-9D

    a should be(3.0)
    b should be(3)
    c should be(2.73)
    d should be(3)
    e should be(3.22)
    f should be(93e-9)
    g should be(f)
    h should be(0)
    i should be(9.23E-9D)

  }




}
