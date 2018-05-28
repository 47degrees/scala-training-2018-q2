package exercises.types

object options {

  def maybeItWillReturnSomething(flag: Boolean): Option[String] = {
    if (flag) Some("Found value") else None
  }


  def getDouble(od: Option[Double]): Double = od match {
    case Some(v) => v
    case None => 0.0
  }

}
