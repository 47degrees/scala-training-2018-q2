package fp

import fp.datatypes._
import fp.program03._
import org.scalatest._

class Program03Spec extends FlatSpec with Matchers {

  "Program03" should "calculate the balance" in {
    balance shouldEqual Yes(180)
  }

  it should "evaluate if I am rich" in {
    amIRich shouldEqual Yes(true)
  }


}
