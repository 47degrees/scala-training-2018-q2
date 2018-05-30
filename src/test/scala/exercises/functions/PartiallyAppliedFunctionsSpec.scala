package exercises.functions

import org.scalatest._

class PartiallyAppliedFunctionsSpec extends FlatSpec with Matchers {

  /** A partially applied function is a function that you do not apply any or all the arguments, creating another function. This partially applied function doesn't apply any arguments.
    */
  it should "Creating a partially applied function" in {
    def sum(a: Int, b: Int, c: Int) = a + b + c
    val sum3                        = sum _
    sum3(1, 9, 7) should be(17)
    sum(4, 5, 6) should be(15)
  }

  /** Partially applied functions can replace any number of arguments:
    */
  it should "Replacing arguments in a partially applied function" in {
    def sum(a: Int, b: Int, c: Int) = a + b + c
    val sumC                        = sum(1, 10, _: Int)
    sumC(4) should be(15)
    sum(4, 5, 6) should be(15)
  }

  /** Currying is a technique to transform a function with multiple parameters into multiple functions which each take one parameter:
    */
  it should "Currying a partially applied function" in {
    def multiply(x: Int, y: Int) = x * y
    (multiply _).isInstanceOf[Function2[_, _, _]] should be(true)
    val multiplyCurried = (multiply _).curried
    multiply(4, 5) should be(20)
    multiplyCurried(3)(2) should be(6)
    val multiplyCurriedFour = multiplyCurried(4)
    multiplyCurriedFour(2) should be(8)
    multiplyCurriedFour(4) should be(16)
  }

  /** Currying allows you to create specialized versions of generalized functions:
    */
  it should "Specializing function with currying technique" in {
    def customFilter(f: Int ⇒ Boolean)(xs: List[Int]) =
      xs filter f
    def onlyEven(x: Int) = x % 2 == 0
    val xs               = List(12, 11, 5, 20, 3, 13, 2)
    customFilter(onlyEven)(xs) should be(List(12, 20, 2))

    val onlyEvenFilter = customFilter(onlyEven) _
    onlyEvenFilter(xs) should be(List(12, 20, 2))
  }

}