package fp

import fp.program06._
import org.scalatest._

class Program06Spec extends FlatSpec with Matchers {

  "Program05" should "calculate the balance" in {
    balance shouldEqual Option(200)
  }

  it should "calculate the balance2" in {
    balance2 shouldEqual Option(200)
  }

  it should "evaluate if I am rich" in {
    amIRich shouldEqual Option(true)
  }

}
