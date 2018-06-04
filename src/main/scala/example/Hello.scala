package example

object Hello extends Greeting {
  println(greeting)
}

trait Greeting {
  lazy val greeting: String = "hello"
}
