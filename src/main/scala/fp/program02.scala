package fp

import fp.datatypes._
import fp.implicits._

object program02 {


  def getBalanceBank1: Maybe[Int] = Yes(100)

  def getBalanceBank2: Maybe[Int] = Yes(80)

  def balance: Maybe[Int] = {

    val b1: Maybe[Int] = getBalanceBank1
    val b2: Maybe[Int] = getBalanceBank2

    b1.combine(b2)
  }


  //EDGE OF THE WORLD
  println(balance)

}
