package fp

import cats.Id
import cats.data.Kleisli
import cats.implicits._

object program06 extends App {

  case class Config(password: String)

  case class Result(hi: String)

  //def myAlgebra(r: Request): F[Response]

  def myOperation(s1: String): Kleisli[Id, Config, Result] = Kleisli { c =>
    Result(c.password ++ s1).pure[Id]
  }




  val myConfig = Config("Jar")

  val k: Kleisli[Id, Config, Result] = myOperation("quepasa")
  val r: Id[Result] = myOperation("quepasa").run(myConfig)


  println(r)




  def getBank1Credentials: Option[String] = Some("MyUser_MyPassword")

  def getBalanceBank1(creds: String): Option[Int] = Some(100)

  def getBalanceBank2: Option[Int] = Some(80)

  val getPocketMoney: Int = 20

  def balance: Option[Int] = {

    val c1: Option[String] = getBank1Credentials
    val b1: Option[Int] = c1.flatMap(getBalanceBank1(_))
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
