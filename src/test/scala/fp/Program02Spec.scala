package fp

import fp.datatypes._
import fp.program02._
import org.scalatest._

class Program02Spec extends FlatSpec with Matchers {

  "Program02" should "calculate the balance" in {
    balance shouldEqual Yes(180)
  }
}
