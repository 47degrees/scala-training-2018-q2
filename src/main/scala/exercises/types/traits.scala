package exercises.types

object traits {

  //Partially implemented
  trait Similarity {
    def isSimilar(x: Any): Boolean
    def isNotSimilar(x: Any): Boolean = !isSimilar(x)
  }


  //Classes extends traits
  case class Event(name: String)

  trait EventListener {
    def listen(event: Event): String
  }

  class MyListener extends EventListener {
    def listen(event: Event): String = {
      event match {
        case Event("password changed") => "Alert"
        case _ => "Nothing of importance occurred"
      }
    }
  }


  //Several traits
  class OurListener

  class MyListener2 extends OurListener with EventListener {
    def listen(event: Event): String = {
      event match {
        case Event("password changed") => "Alert"
        case _ => "Nothing of importance occurred"
      }
    }
  }


}
