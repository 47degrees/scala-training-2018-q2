package exercises.statements

import org.scalatest._

class PatternMatchingSpec extends FlatSpec with Matchers {

  /** Scala has a built-in general pattern matching mechanism. It allows to match on any sort of data with a first-match policy.
    * Here is a small example which shows how to match against an integer value:
    *
    * {{{
    * object MatchTest1 extends App {
    * def matchTest(x: Int): String = x match {
    * case 1 => "one"
    * case 2 => "two"
    * case _ => "many" // case _ will trigger if all other cases fail.
    * }
    * println(matchTest(3)) // prints "many"
    * }
    * }}}
    *
    * The block with the `case` statements defines a function which maps integers to strings. The `match` keyword provides a convenient way of applying a function (like the pattern matching function above) to an object.
    *
    * Scala's pattern matching statement is most useful for matching on algebraic types expressed via `case classes`.
    * Scala also allows the definition of patterns independently of case classes, using `unapply` methods in extractor objects.
    *
    * Pattern matching returns something:
    */
  it should "Basic example" in {
    val stuff = "blue"

    val myStuff = stuff match {
      case "red" ⇒
        println("RED"); 1
      case "blue" ⇒
        println("BLUE"); 2
      case "green" ⇒
        println("GREEN"); 3
      case _ ⇒
        println(stuff); 0 // case _ will trigger if all other cases fail.
    }

    myStuff should be(2)
  }

  /** Pattern matching can return complex values:
    */
  it should "Basic example returning complex values" in {
    val stuff = "blue"

    val myStuff = stuff match {
      case "red"   ⇒ (255, 0, 0)
      case "green" ⇒ (0, 255, 0)
      case "blue"  ⇒ (0, 0, 255)
      case _       ⇒ println(stuff); 0
    }

    myStuff should be((0, 0, 255))
  }

  /** Pattern matching can match complex expressions:
    */
  it should "Basic example matching complex values" in {
    def goldilocks(expr: Any) = expr match {
      case ("porridge", "Papa") ⇒ "Papa eating porridge"
      case ("porridge", "Mama") ⇒ "Mama eating porridge"
      case ("porridge", "Baby") ⇒ "Baby eating porridge"
      case _                    ⇒ "what?"
    }

    goldilocks(("porridge", "Mama")) should be("Mama eating porridge")
  }

  /** Pattern matching can wildcard parts of expressions:
    */
  it should "Basic example with wildcards" in {
    def goldilocks(expr: Any) = expr match {
      case ("porridge", _)   ⇒ "eating"
      case ("chair", "Mama") ⇒ "sitting"
      case ("bed", "Baby")   ⇒ "sleeping"
      case _                 ⇒ "what?"
    }

    goldilocks(("porridge", "Papa")) should be("eating")
    goldilocks(("chair", "Mama")) should be("sitting")
  }

  /** Pattern matching can substitute parts of expressions:
    */
  it should "Basic example with substitution" in {
    def goldilocks(expr: Any) = expr match {
      case ("porridge", bear) ⇒
        bear + " said someone's been eating my porridge"
      case ("chair", bear) ⇒ bear + " said someone's been sitting in my chair"
      case ("bed", bear)   ⇒ bear + " said someone's been sleeping in my bed"
      case _               ⇒ "what?"
    }

    goldilocks(("porridge", "Papa")) should be("Papa said someone's been eating my porridge")
    goldilocks(("chair", "Mama")) should be("Mama said someone's been sitting in my chair")
  }

  /** A backquote can be used to refer to a stable variable in scope to create a case statement - this prevents "variable shadowing":
    */
  it should "Basic example with backquote" in {
    val foodItem = "porridge"

    def goldilocks(expr: Any) = expr match {
      case (`foodItem`, _)   ⇒ "eating"
      case ("chair", "Mama") ⇒ "sitting"
      case ("bed", "Baby")   ⇒ "sleeping"
      case _                 ⇒ "what?"
    }

    goldilocks(("porridge", "Papa")) should be("eating")
    goldilocks(("chair", "Mama")) should be("sitting")
    goldilocks(("porridge", "Cousin")) should be("eating")
    goldilocks(("beer", "Cousin")) should be("what?")
  }

  /** A backquote can be used to refer to a method parameter as a stable variable to create a case statement:
    */
  it should "Basic example with backquote in method parameter" in {
    def patternEquals(i: Int, j: Int) = j match {
      case `i` ⇒ true
      case _   ⇒ false
    }
    patternEquals(3, 3) should be(true)
    patternEquals(7, 9) should be(false)
    patternEquals(9, 9) should be(true)
  }

  /** To pattern match against a `List`, the list can be split into parts, in this case the head `x` and the tail `xs`. Since the case doesn't terminate in `Nil`, `xs` is interpreted as the rest of the list:
    */
  it should "List example" in {
    val secondElement = List(1, 2, 3) match {
      case x :: xs ⇒ xs.head
      case _       ⇒ 0
    }

    secondElement should be(2)
  }

  /** To obtain the second element you can expand on the pattern. Where `x` is the first element, `y` is the second element, and `xs` is the rest:
    */
  it should "List example for extracting the second element" in {
    val secondElement = List(1, 2, 3) match {
      case x :: y :: xs ⇒ y
      case _            ⇒ 0
    }

    secondElement should be(2)
  }

  /** Same koan as above, but we are pattern matching a list with only one item!
    */
  it should "List example for extracting the second element from a shorter list" in {
    val secondElement = List(1) match {
      case x :: y :: xs ⇒ y // only matches a list with two or more items
      case _            ⇒ 0
    }

    secondElement should be(0)
  }

  /** To pattern match against `List`, you can also establish a pattern match if you know the exact number of elements in a `List`:
    */
  it should "List example to check size" in {
    val r = List(1, 2, 3) match {
      case x :: y :: Nil ⇒ y // only matches a list with exactly two items
      case _             ⇒ 0
    }

    r should be(0)
  }

  /** If a pattern is exactly one element longer than a `List`, it extracts the final `Nil`:
    */
  it should "List example extracting Nil" in {
    val r = List(1, 2, 3) match {
      case x :: y :: z :: tail ⇒ tail
      case _                   ⇒ 0
    }

    r == Nil should be(true)
  }

}
