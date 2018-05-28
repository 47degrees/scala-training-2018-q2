package exercises.types

import exercises.types.traits._
import org.scalatest._

class TraitsSpec extends FlatSpec with Matchers {

  "Traits" should "be extended by classes" in {

    val evt1 = Event("user created")
    val evt2 = Event("password changed")

    val myListener = new MyListener

    myListener.listen(evt1) shouldBe "Nothing of importance occurred"
    myListener.listen(evt2) shouldBe "Alert"


  }

  it should "be mixed using with" in {

    val evt1 = Event("user created")
    val evt2 = Event("password changed")

    val myListener = new MyListener2

    myListener.listen(evt1) shouldBe "Nothing of importance occurred"
    myListener.listen(evt2) shouldBe "Alert"

  }




}
