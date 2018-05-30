package exercises.functions

import org.scalatest._

class ByNameParameterSpec extends FlatSpec with Matchers {

  /** `() => Int` is a Function type that takes a `Unit` type. `Unit` is known as `void` to a Java programmer. The function returns an `Int`. You can place this as a method parameter so that you can you use it as a block, but still it doesn't look quite right:
    */
  it should "Passing a function with Unit as argument" in {
    def calc(x: () ⇒ Int): Either[Throwable, Int] = {
      try {
        Right(x()) //An explicit call of the x function
      } catch {
        case b: Throwable ⇒ Left(b)
      }
    }

    val y = calc { () ⇒ //Having explicitly declaring that Unit is a parameter with ()
      14 + 15
    }

    y should be(Right(29))
  }

  /** A by-name parameter does the same thing as the previous koan but there is no need to explicitly handle `Unit` or `()`. This is used extensively in Scala to create blocks:
    */
  it should "Using by-name parameter" in {
    def calc(x: ⇒ Int): Either[Throwable, Int] = {
      //x is a call by name parameter
      try {
        Right(x)
      } catch {
        case b: Throwable ⇒ Left(b)
      }
    }

    val y = calc {
      //This looks like a natural block
      println("Here we go!") //Some superfluous call
      val z = List(1, 2, 3, 4) //Another superfluous call
      49 + 20
    }

    y should be(Right(69))
  }

  /** By name parameters can also be used with `object` and `apply` to make interesting block-like calls:
    */
  it should "Using by-name parameter in objects" in {
    object PigLatinizer {
      def apply(x: ⇒ String) = x.tail + x.head + "ay"
    }

    val result = PigLatinizer {
      val x = "pret"
      val z = "zel"
      x ++ z //concatenate the strings
    }

    result should be("retzelpay")
  }

}