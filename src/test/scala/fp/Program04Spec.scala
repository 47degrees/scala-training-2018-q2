package fp

import fp.datatypes._
import fp.program04._
import org.scalatest._

class Program04Spec extends FlatSpec with Matchers {

  "Program04" should "calculate the balance" in {
    balance shouldEqual Yes(200)
  }

  it should "evaluate if I am rich" in {
    amIRich shouldEqual Yes(true)
  }

}
