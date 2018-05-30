package exercises.functions

import org.scalatest._

class HighOrderFunctionsSpec extends FlatSpec with Matchers {

  /** Meet lambda. Scala provides a relatively lightweight syntax for defining anonymous functions. Anonymous functions in source code are called function literals and at run time, function literals are instantiated into objects called function values.
    *
    * Scala supports first-class functions, which means you can express functions in function literal syntax, i.e. ` (x: Int) => x + 1`, and those functions can be represented by objects, which are called function values.
    */
  it should "Meet lambda" in {
    def lambda = { x: Int ⇒
      x + 1
    }
    def lambda2 = (x: Int) ⇒ x + 2
    val lambda3 = (x: Int) ⇒ x + 3

    val lambda4 = new Function1[Int, Int] {
      def apply(v1: Int): Int = v1 - 1
    }

    def lambda5(x: Int) = x + 1

    val result           = lambda(3)
    val `result1andhalf` = lambda.apply(3)

    val result2 = lambda2(3)
    val result3 = lambda3(3)
    val result4 = lambda4(3)
    val result5 = lambda5(3)

    result should be(4)
    result1andhalf should be(4)
    result2 should be(5)
    result3 should be(6)
    result4 should be(2)
    result5 should be(4)
  }

  /** An anonymous function can also take on a different look by taking out the brackets:
    */
  it should "Another way of defining anonymous functions" in {
    def lambda = (x: Int) ⇒ x + 1
    def result = lambda(5)
    result should be(6)
  }

  /** Here the only variable used in the function body, `i * 10`, is `i`, which is defined as a parameter to the function.
    *
    *{{{
    * val multiplier = (i:Int) => i * 10
    * }}}
    *
    * A closure is a function which maintains a reference to one or more variables outside of the function scope (it "closes over" the variables).  Scala will detect that you are using variables outside of scope and create an object instance to hold the shared variables.
    */
  it should "Closure example" in {
    var incrementer = 1

    def closure = { x: Int ⇒
      x + incrementer
    }

    val result1 = closure(10)
    result1 should be(11)

    incrementer = 2

    val result2 = closure(10)
    result2 should be(12)
  }

  /** And then we get to Higher Order Functions:
    * Higher Order Functions are functions that take functions as arguments and/or return functions.
    *
    *  We can take that closure and throw it into a Higher Order Function and it will still hold the environment:
    */
  it should "High order function receiving a function as parameter" in {
    def summation(x: Int, y: Int ⇒ Int) = y(x)

    var incrementer = 3
    def closure     = (x: Int) ⇒ x + incrementer

    val result = summation(10, closure)
    result should be(13)

    incrementer = 4
    val result2 = summation(10, closure)
    result2 should be(14)
  }

  /** Higher Order Function returning another function:
    */
  it should "High order function returning a function" in {
    def addWithoutSyntaxSugar(x: Int): Function1[Int, Int] = {
      new Function1[Int, Int]() {
        def apply(y: Int): Int = x + y
      }
    }
    addWithoutSyntaxSugar(1).isInstanceOf[Function1[Int, Int]] should be(true)

    addWithoutSyntaxSugar(2)(3) should be(5)

    def fiveAdder: Function1[Int, Int] = addWithoutSyntaxSugar(5)
    fiveAdder(5) should be(10)
  }

  /** Function returning another function using an anonymous function:
    */
  it should "High order function returning a function using an anonymous function" in {
    def addWithSyntaxSugar(x: Int) = (y: Int) ⇒ x + y

    addWithSyntaxSugar(1).isInstanceOf[Function1[Int, Int]] should be(true)
    addWithSyntaxSugar(2)(3) should be(5)

    def fiveAdder = addWithSyntaxSugar(5)
    fiveAdder(5) should be(10)
  }

  /** `isInstanceOf` is the same as `instanceof` in java, but in this case the parameter types can be *blanked out* using existential types with a single underline, since parameter types are unknown at runtime.
    */
  it should "Blank parameter types in isInstanceOf" in {
    def addWithSyntaxSugar(x: Int) = (y: Int) ⇒ x + y

    addWithSyntaxSugar(1).isInstanceOf[Function1[_, _]] should be(true)
  }

  /** Function taking another function as a parameter. Helps in composing functions.
    *
    * Hint: a map method applies the function to each element of a list.
    */
  it should "Using functions as parameters in high order functions" in {
    def makeUpper(xs: List[String]) = xs map {
      _.toUpperCase
    }

    def makeWhatEverYouLike(xs: List[String], sideEffect: String ⇒ String) =
      xs map sideEffect

    makeUpper(List("abc", "xyz", "123")) should be(List("ABC", "XYZ", "123"))

    makeWhatEverYouLike(List("ABC", "XYZ", "123"), { x ⇒
      x.toLowerCase
    }) should be(List("abc", "xyz", "123"))

    //using it inline
    val myName = (name: String) => s"My name is $name"
    makeWhatEverYouLike(List("John", "Mark"), myName) should be(List("My name is John", "My name is Mark"))

    List("Scala", "Erlang", "Clojure") map (_.length) should be(List(5, 6, 7))
  }

}
