package functional

object program01 extends App {

  def getBalanceFromBank1: Int = ???

  def getBalanceFromBank2: Int = ???


  def getMyBalance: Int = {
    val b1: Int = getBalanceFromBank1
    val b2: Int = getBalanceFromBank2
    b1 + b2
  }

  //Edge of the world
  println(getMyBalance)

}
