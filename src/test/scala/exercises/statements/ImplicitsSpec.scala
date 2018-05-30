package exercises.statements

import org.scalatest._
import scala.language.implicitConversions

class ImplicitsSpec extends FlatSpec with Matchers {

  /** The actual arguments that are eligible to be passed to an implicit parameter fall into two categories:
    *
    *  - First, eligible are all identifiers x that can be accessed at the point of the method call without a prefix and that denote an implicit definition or an implicit parameter.
    *  - Second, eligible are also all members of companion modules of the implicit parameter's type that are labeled implicit.
    *
    * In the following example we define a method `sum` which computes the sum of a list of elements using the monoid's `add` and `unit` operations. Please note that implicit values can not be top-level, they have to be members of a template.
    *
    * {{{
    * abstract class SemiGroup[A] {
    * def add(x: A, y: A): A
    * }
    * abstract class Monoid[A] extends SemiGroup[A] {
    * def unit: A
    * }
    * object ImplicitTest extends App {
    * implicit object StringMonoid extends Monoid[String] {
    * def add(x: String, y: String): String = x concat y
    * def unit: String = ""
    * }
    * implicit object IntMonoid extends Monoid[Int] {
    * def add(x: Int, y: Int): Int = x + y
    * def unit: Int = 0
    * }
    * def sum[A](xs: List[A])(implicit m: Monoid[A]): A =
    * if (xs.isEmpty) m.unit
    * else m.add(xs.head, sum(xs.tail))
    * println(sum(List(1, 2, 3)))
    * println(sum(List("a", "b", "c")))
    * }
    * }}}
    *
    * Here is the output of the Scala program:
    *
    * {{{
    * 6
    * abc
    * }}}
    *
    * Implicits wrap around existing classes to provide extra functionality. This is similar to monkey patching in Ruby and meta-programming in Groovy.
    *
    * Creating a method `isOdd` for `Int`, which doesn't exist:
    */
  it should "Implicit conversion within the scope" in {
    class KoanIntWrapper(val original: Int) {
      def isOdd = original % 2 != 0
    }

    implicit def thisMethodNameIsIrrelevant(value: Int) =
      new KoanIntWrapper(value)

    19.isOdd should be(true)
    20.isOdd should be(false)
  }

  /** Implicits rules can be imported into your scope with an import:
    */
  it should "Implicit conversion by importing into the scope" in {
    object MyPredef {

      class KoanIntWrapper(val original: Int) {
        def isOdd = original % 2 != 0

        def isEven = !isOdd
      }

      implicit def thisMethodNameIsIrrelevant(value: Int) =
        new KoanIntWrapper(value)
    }

    import MyPredef._
    //imported implicits come into effect within this scope
    19.isOdd should be(true)
    20.isOdd should be(false)
  }

  /** Implicits can be used to automatically convert a value's type to another:
    */
  it should "Implicit conversion of types" in {
    import java.math.BigInteger
    implicit def Int2BigIntegerConvert(value: Int): BigInteger =
      new BigInteger(value.toString)

    def add(a: BigInteger, b: BigInteger) = a.add(b)

    add(Int2BigIntegerConvert(3), Int2BigIntegerConvert(6)) == Int2BigIntegerConvert(9) should be(true)

    add(3, 6) == 9 should be(false)
    add(3, 6) == Int2BigIntegerConvert(9) should be(true)

    add(3, 6) == (9: BigInteger) should be(true)
    add(3, 6).intValue == 9 should be(true)
  }

  /** Implicits can be used to declare a value to be provided as a default as long as an implicit value is set with in the scope.  These are called Implicit Function Parameters:
    */
  it should "Declaring default implicit value" in {
    def howMuchCanIMake_?(hours: Int)(implicit dollarsPerHour: BigDecimal) =
      dollarsPerHour * hours

    implicit val hourlyRate: BigDecimal = BigDecimal(34)

    howMuchCanIMake_?(30) should be(1020)
  }

  /** Implicit Function Parameters can contain a list of implicits:
    */
  it should "Declaring default implicit values" in {
    def howMuchCanIMake_?(hours: Int)(implicit amount: BigDecimal, currencyName: String) =
      (amount * hours).toString() + " " + currencyName

    implicit val hourlyRate: BigDecimal = BigDecimal(34)
    implicit val currencyName: String   = "Dollars"

    howMuchCanIMake_?(30) should be("1020 Dollars")
  }

  /** Default arguments, though, are preferred to Implicit Function Parameters:
    */
  it should "Declaring default arguments" in  {
    def howMuchCanIMake_?(hours: Int, amount: BigDecimal = 34, currencyName: String = "Dollars") =
      (amount * hours).toString() + " " + currencyName

    howMuchCanIMake_?(30) should be("1020 Dollars")

    howMuchCanIMake_?(30, 95) should be("2850 Dollars")
  }

}
