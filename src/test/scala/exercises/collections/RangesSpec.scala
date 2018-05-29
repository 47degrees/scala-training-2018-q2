package exercises.collections

import org.scalatest._

class RangesSpec extends FlatSpec with Matchers {

  /** A Range is an ordered sequence of integers that are equally spaced apart. For example, "1, 2, 3" is a range, as is "5, 8, 11, 14". To create a range in Scala, use the predefined methods `to`, `until`, and `by`. `1 to 3` generates "1, 2, 3" and `5 to 14 by 3` generates "5, 8, 11, 14".
    *
    * If you want to create a range that is exclusive of its upper limit, then use `until` instead of `to`: `1 until 3` generates "1, 2".
    *
    * Note that `Range(a, b, c)` is the same as `a until b by c`
    *
    * Ranges are represented in constant space, because they can be defined by just three numbers: their start, their end, and the stepping value. Because of this representation, most operations on ranges are extremely fast.
    *
    * A range's upper bound is not inclusive:
    */
  "Ranges" should "upperNotInclusiveRangeExercises" in {
    val someNumbers = Range(0, 10)
    val second = someNumbers(1)
    val last = someNumbers.last

    someNumbers.size should be(10)
    second should be(1)
    last should be(9)
  }

  /** Ranges can be specified using 'until':
    */
  it should "untilRangeExercises" in {
    val someNumbers = Range(0, 10)
    val otherRange = 0 until 10

    (someNumbers == otherRange) should be(true)
  }

  /** Range can specify a step for an increment:
    */
  it should "incrementsRangeExercises" in {
    val someNumbers = Range(2, 10, 3)
    val second = someNumbers(1)
    val last = someNumbers.last

    someNumbers.size should be(3)
    second should be(5)
    last should be(8)
  }

  /** A range does not include its upper bound, even in a step increment:
    */
  it should "upperInIncrementRangeExercises" in {
    val someNumbers = Range(0, 34, 2)
    someNumbers.contains(33) should be(false)
    someNumbers.contains(32) should be(true)
    someNumbers.contains(34) should be(false)
  }

  /** Range can specify to include its upper bound value:
    */
  it should "specifyUpperRangeExercises" in {
    val someNumbers = Range(0, 34).inclusive

    someNumbers.contains(34) should be(true)
  }

  /** Inclusive ranges can be specified using 'to':
    */
  it should "inclusiveWithToRangeExercises" in {
    val someNumbers = Range(0, 34).inclusive
    val otherRange = 0 to 34

    (someNumbers == otherRange) should be(true)
  }
}
