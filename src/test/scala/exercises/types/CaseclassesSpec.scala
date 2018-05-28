package exercises.types

import exercises.types.caseclasses.{Dog, Person}
import org.scalatest._

class CaseclassesSpec extends FlatSpec with Matchers {

  val d1 = Dog("Scooby", "Doberman")
  val d2 = Dog("Rex", "Custom")
  val d3 = Dog("Scooby", "Doberman")

  "Case classes" should "implement eq/equals method" in {

    d1.eq(d3) shouldBe false
    d1.eq(d2) shouldBe false
    d2.eq(d3) shouldBe false

    d1.equals(d3) shouldBe true
  }

  it should "have an automatic hashcode method that works" in {

    (d1.hashCode == d2.hashCode) should be(false)
    (d1.hashCode == d3.hashCode) should be(true)

  }

  it should "have a convenient toString method defined" in {

    d1.toString should be("Dog(Scooby,Doberman)")

  }

  it should "have automatic properties" in {

    d1.name should be("Scooby")
    d1.breed should be("Doberman")

  }

  it should "have safer alternatives for altering " in {

    val d4 = Dog("Leo", "Golden")

    //d4.name = "Mumu"

    d4.name should be("Leo")

    val d5 = d4.copy(name = "Mumu")

    d4.name shouldBe "Leo"
    d5.name shouldBe "Mumu"

  }

  it should "can have default and named parameters " in {

    val p1 = Person("Fred Jones", 23, "111-22-3333")
    val p2 = Person("Samantha Jones") // note missing age and ssn
    val p3 = Person(age = 21, name = "Fred Jones", ssn = "111-22-3333") // note the order can change, and missing age
    val p4 = p3.copy(age = 23)

    p1.name should be("Fred Jones")
    p1.age should be(23)
    p1.ssn should be("111-22-3333")

    p2.name should be("Samantha Jones")
    p2.age should be(0)
    p2.ssn should be("")

    p3.name should be("Fred Jones")
    p3.age should be(21)
    p3.ssn should be("111-22-3333")

    p4.name should be("Fred Jones")
    p4.age should be(23)
    p4.ssn should be("111-22-3333")

    (p1 == p4) should be(true)

  }


}
