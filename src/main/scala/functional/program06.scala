package functional

import cats.implicits._

object program06 extends App {


  // Maybe == Option
  // Yes == Some
  // No == None
  // Combinator == Monoid
  // Transformer ~= Functor
  // Lifter ~= Applicative
  // Flattener ~= Monad



  def getBank1Credentials: Option[String] = Option("User+Password")

  def getBalanceFromBank1(credentials: String): Option[Int] = credentials match {
    case "User+Password" => Option(100)
    case _ => None
  }

  def getBalanceFromBank2: Option[Int] = Option(80)

  val getPocketMoney: Int = 20


  def getMyBalance: Option[Int] = {
    val c: Option[String] = getBank1Credentials
    val b1: Option[Int] = c.flatMap(cred => getBalanceFromBank1(cred))
    val b2: Option[Int] = getBalanceFromBank2
    b1.combine(b2).combine(getPocketMoney.pure[Option])
  }

  def getMyBalance2: Option[Int] = for {
      cred <- getBank1Credentials
      b1 <- getBalanceFromBank1(cred)
      b2 <- getBalanceFromBank2
      p <- getPocketMoney.pure[Option]
    } yield b1 + b2 + p


  def amIRich: Option[Boolean] = getMyBalance2.map(_ > 150)


  //Edge of the world
  println(getMyBalance2)
  println(amIRich)

}
