package exercises.collections

import org.scalatest._

class SequencesSpec extends FlatSpec with Matchers {

  /** Scala provides a data structure, the array, which stores a fixed-size sequential collection of elements of the same type. An array is used to store a collection of data, but it is often more useful to think of an array as a collection of variables of the same type.
    *
    * A list can be converted to an array:
    */
  "Sequences and arrays" should "sequentialCollectionSequencesandArrays" in {
    val l = List(1, 2, 3)
    val a = l.toArray
    a should equal(Array(1, 2, 3))
  }

  /** Sequences are special cases of iterable collections of class `Iterable`. Unlike iterables, sequences always have a defined order of elements.
    *
    * Any sequence can be converted to a list:
    *
    */
  it should "orderedElementsSequencesandArrays" in {
    val a = Array(1, 2, 3)
    val s = a.toSeq
    val l = s.toList
    l should equal(List(1, 2, 3))
  }

  /** You can create a sequence from a `for` loop:
    */
  it should "fromForComprehensionSequencesandArrays" in {
    val s = for (v ← 1 to 4) yield v
    s.toList should be(List(1, 2, 3, 4))
  }

  /** You can create a sequence from a `for` loop with a filter:
    */
  it should "withConditionSequencesandArrays" in {
    val s = for (v ← 1 to 10 if v % 3 == 0) yield v
    s.toList should be(List(3, 6, 9))
  }

  /** You can filter any sequence based on a predicate:
    */
  it should "filterPredicateSequencesandArrays" in {
    val s = Seq("hello", "to", "you")
    val filtered = s.filter(_.length > 2)
    filtered should be(Seq("hello", "you"))
  }

  /** You can also filter Arrays in the same way:
    */
  it should "filterArraySequencesandArrays" in {
    val a = Array("hello", "to", "you", "again")
    val filtered = a.filter(_.length > 3)
    filtered should be(Array("hello", "again"))
  }

  /** You can map values in a sequence through a function:
    */
  it should "mapValuesSequencesandArrays" in {
    val s = Seq("hello", "world")
    val r = s map {
      _.reverse
    }

    r should be(Seq("olleh", "dlrow"))
  }
}
