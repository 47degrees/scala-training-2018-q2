package functional

import functional.datatypes._
import functional.implicits._
import functional.typeclasses._

object program05 extends App {

  def getBank1Credentials: Maybe[String] = Maybe("User+Password")

  def getBalanceFromBank1(credentials: String): Maybe[Int] = credentials match {
    case "User+Password" => Yes(100)
    case _ => No
  }

  def getBalanceFromBank2: Maybe[Int] = Yes(80)

  val getPocketMoney: Int = 20


  def getMyBalance: Maybe[Int] = {
    val c: Maybe[String] = getBank1Credentials
    val b1: Maybe[Int] = c.flatMap(cred => getBalanceFromBank1(cred))
    val b2: Maybe[Int] = getBalanceFromBank2
    b1.combine(b2).combine(getPocketMoney.pure[Maybe])
  }

  def getMyBalance2: Maybe[Int] = for {
      cred <- getBank1Credentials
      b1 <- getBalanceFromBank1(cred)
      b2 <- getBalanceFromBank2
      p <- getPocketMoney.pure[Maybe]
    } yield b1 + b2 + p


  def amIRich: Maybe[Boolean] = getMyBalance2.map(_ > 150)


  //Edge of the world
  println(getMyBalance2)
  println(amIRich)

}
