package fp

import fp.datatypes._
import fp.implicits._

object program05 {

  def getBank1Credentials: Maybe[String] = Yes("MyUser_MyPassword")

  def getBalanceBank1(creds: String): Maybe[Int] = Yes(100)

  def getBalanceBank2: Maybe[Int] = Yes(80)

  def getPocketMoney: Int = 20

  def balance: Maybe[Int] = {

    val c1: Maybe[String] = getBank1Credentials
    val b1: Maybe[Int] = c1.flatMap(getBalanceBank1(_))
    val b2: Maybe[Int] = getBalanceBank2

    b1.combine(b2).combine(getPocketMoney.pure[Maybe])
  }

  def balance2: Maybe[Int] = for {
    c <- getBank1Credentials
    b1 <- getBalanceBank1(c)
    b2 <- getBalanceBank2
    p <- getPocketMoney.pure
  } yield b1 + b2 + p

  def amIRich: Maybe[Boolean] = balance2.map(_ > 150)

  //EDGE OF THE WORLD
  println(balance2)
  println(amIRich)

}
