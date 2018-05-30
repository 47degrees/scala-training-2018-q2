package exercises.functions

import org.scalatest._

class PartialFunctionsSpec extends FlatSpec with Matchers {

  /** A partial function is a `trait` that when implemented can be used as building blocks to determine a solution.  The trait `PartialFunction` requires that the method `isDefinedAt` and `apply` be implemented:
    */
  it should "Example for partial function" in {
    val doubleEvens: PartialFunction[Int, Int] =
      new PartialFunction[Int, Int] {
        //States that this partial function will take on the task
        def isDefinedAt(x: Int) = x % 2 == 0

        //What we do if this partial function matches
        def apply(v1: Int) = v1 * 2
      }

    val tripleOdds: PartialFunction[Int, Int] = new PartialFunction[Int, Int] {
      def isDefinedAt(x: Int) = x % 2 != 0

      def apply(v1: Int) = v1 * 3
    }

    val whatToDo = doubleEvens orElse tripleOdds //Here we chain the partial functions together

    whatToDo(3) should be(9)
    whatToDo(4) should be(8)
  }

  /** Case statements are a quick way to create partial functions. When you create a case statement, the `apply` and `isDefinedAt` methods are created automatically.
    */
  it should "Creating partial function with case statements" in {
    //These case statements are called case statements with guards
    val doubleEvens: PartialFunction[Int, Int] = {
      case x if (x % 2) == 0 ⇒ x * 2
    }
    val tripleOdds: PartialFunction[Int, Int] = {
      case x if (x % 2) != 0 ⇒ x * 3
    }

    val whatToDo = doubleEvens orElse tripleOdds //Here we chain the partial functions together
    whatToDo(3) should be(9)
    whatToDo(4) should be(8)
  }

  /** The result of partial functions can have an `andThen` function added to the end of the chain:
    */
  it should "Adding andThen to a chain of partial functions" in {
    //These are called case statements with guards
    val doubleEvens: PartialFunction[Int, Int] = {
      case x if (x % 2) == 0 ⇒ x * 2
    }
    val tripleOdds: PartialFunction[Int, Int] = {
      case x if (x % 2) != 0 ⇒ x * 3
    }

    val addFive  = (x: Int) ⇒ x + 5
    val whatToDo = doubleEvens orElse tripleOdds andThen addFive //Here we chain the partial functions together
    whatToDo(3) should be(14)
    whatToDo(4) should be(13)
  }

  /** `andThen` can be used to continue onto another chain of logic:
    */
  it should "Adding another chain of logic with andThen" in {
    val doubleEvens: PartialFunction[Int, Int] = {
      case x if (x % 2) == 0 ⇒ x * 2
    }
    val tripleOdds: PartialFunction[Int, Int] = {
      case x if (x % 2) != 0 ⇒ x * 3
    }

    val printEven: PartialFunction[Int, String] = {
      case x if (x % 2) == 0 ⇒ "Even"
    }
    val printOdd: PartialFunction[Int, String] = {
      case x if (x % 2) != 0 ⇒ "Odd"
    }

    val whatToDo = doubleEvens orElse tripleOdds andThen (printEven orElse printOdd)

    whatToDo(3) should be("Odd")
    whatToDo(4) should be("Even")
  }

}
