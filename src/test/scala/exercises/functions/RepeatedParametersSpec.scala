package exercises.functions

import RepeatedParametersHelper._
import org.scalatest._

class RepeatedParametersSpec extends FlatSpec with Matchers {

  /** A repeated parameter must be the last parameter and this will let you add as many extra parameters as needed.
    *
    * Given:
    *
    * {{{
    * def repeatedParameterMethod(x: Int, y: String, z: Any*) = {
    * "%d %ss can give you %s".format(x, y, z.mkString(", "))
    * }
    * }}}
    * Resolve:
    *
    */
  it should "Repeating the last parameter" in {
    repeatedParameterMethod(3, "egg", "a delicious sandwich", "protein", "high cholesterol") should be(
      "3 eggs can give you a delicious sandwich, protein, high cholesterol")
  }

  /** A repeated parameter can accept a collection as the last parameter but will be considered a single object:
    */
  it should "Using a collection for the last parameter as a single object" in {
    repeatedParameterMethod(3, "egg", List("a delicious sandwich", "protein", "high cholesterol")) should be(
      "3 eggs can give you List(a delicious sandwich, protein, high cholesterol)")
  }

  /** A repeated parameter can accept a collection - if you want it expanded, add `:_*`
    */
  it should "Expanding a collection for the last parameter" in {
    repeatedParameterMethod(
      3,
      "egg",
      List("a delicious sandwich", "protein", "high cholesterol"): _*) should be(
      "3 eggs can give you a delicious sandwich, protein, high cholesterol")
  }

}