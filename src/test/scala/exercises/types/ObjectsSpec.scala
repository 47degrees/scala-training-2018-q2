package exercises.types

import exercises.types.objects.{Greeting, Movie, Nerd}
import org.scalatest._

class ObjectsSpec extends FlatSpec with Matchers {

  "Objects" should "have all its instances as equivalents" in {

    val x = Greeting
    val y = x

    val z = Greeting

    x.eq(y) shouldBe true
    x.eq(z) shouldBe true
  }

  it should "have companion object as factory" in {

    Movie.academyAwardBestMoviesForYear(1932).get.name should be("Grand Hotel")
  }

  it should "have companion object wich access to private values" in {

    val rafa = new Nerd("Rafa", "Superman")
    val paco = new Nerd("Paco", "Spider-Man")

    Nerd.showMeInnerSecret(rafa) should be("Superman")
    Nerd.showMeInnerSecret(paco) should be("Spider-Man")
  }


}
