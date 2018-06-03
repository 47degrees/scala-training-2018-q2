package fp

import fp.datatypes._
import fp.program05._
import org.scalatest._

class Program05Spec extends FlatSpec with Matchers {

  "Program05" should "calculate the balance" in {
    balance shouldEqual Yes(200)
  }

  it should "calculate the balance2" in {
    balance2 shouldEqual Yes(200)
  }

  it should "evaluate if I am rich" in {
    amIRich shouldEqual Yes(true)
  }

}
