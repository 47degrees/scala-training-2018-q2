package functional

import functional.datatypes._
import functional.implicits._
import functional.typeclasses._

object program04 extends App {

  def getBalanceFromBank1: Maybe[Int] = Yes(100)

  def getBalanceFromBank2: Maybe[Int] = Yes(80)

  val getPocketMoney: Int = 20


  def getMyBalance: Maybe[Int] = {
    val b1: Maybe[Int] = getBalanceFromBank1
    val b2: Maybe[Int] = getBalanceFromBank2
    b1.combine(b2).combine(getPocketMoney.pure[Maybe])
  }

  def amIRich: Maybe[Boolean] = getMyBalance.map(_ > 150)


  //Edge of the world
  println(getMyBalance)
  println(amIRich)

}
