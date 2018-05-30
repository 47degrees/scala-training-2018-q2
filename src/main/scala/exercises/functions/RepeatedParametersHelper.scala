package exercises.functions

object RepeatedParametersHelper {

  def repeatedParameterMethod(x: Int, y: String, z: Any*): String =
    "%d %ss can give you %s".format(x, y, z.mkString(", "))
}
