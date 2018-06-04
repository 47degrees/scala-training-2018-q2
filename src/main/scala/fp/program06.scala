package fp

import cats.implicits._

object program06 {

  def getBank1Credentials: Option[String] = Some("MyUser_MyPassword")

  def getBalanceBank1(creds: String): Option[Int] = Some(100)

  def getBalanceBank2: Option[Int] = Some(80)

  def getPocketMoney: Int = 20

  def balance: Option[Int] = {

    val c1: Option[String] = getBank1Credentials
    val b1: Option[Int] = c1.flatMap(getBalanceBank1)
    val b2: Option[Int] = getBalanceBank2

    b1.combine(b2).combine(getPocketMoney.pure[Option])
  }

  def balance2: Option[Int] = for {
    c <- getBank1Credentials
    b1 <- getBalanceBank1(c)
    b2 <- getBalanceBank2
    p <- getPocketMoney.pure[Option]
  } yield b1 + b2 + p

  def amIRich: Option[Boolean] = balance2.map(_ > 150)

  //EDGE OF THE WORLD
  println(balance2)
  println(amIRich)

}
