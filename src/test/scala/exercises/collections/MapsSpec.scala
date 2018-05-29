package exercises.collections

import org.scalatest._

class MapsSpec extends FlatSpec with Matchers {

  /** A `Map` is an `Iterable` consisting of pairs of keys and values (also named mappings or associations). Scala's Predef class offers an implicit conversion that lets you write `key -> value` as an alternate syntax for the pair `(key, value)`. For instance `Map("x" -> 24, "y" -> 25, "z" -> 26)` means exactly the same as `Map(("x", 24), ("y", 25), ("z", 26))`, but reads better.
    *
    * The fundamental operations on maps are similar to those on sets. They are summarized in the following table and fall into the following categories:
    *
    *  - Lookup operations `apply`, `get`, `getOrElse`, `contains`, and `isDefinedAt`. These turn maps into partial functions from keys to values. The fundamental lookup method for a map is: `def get(key): Option[Value]`. The operation "`m get key`" tests whether the map contains an association for the given key. If so, it returns the associated value in a `Some`. If no key is defined in the map, get returns `None`. Maps also define an `apply` method that returns the value associated with a given key directly, without wrapping it in an `Option`. If the key is not defined in the map, an exception is raised.
    *  - Additions and updates `+`, `++`, `updated`, which let you add new bindings to a map or change existing bindings.
    *  - Removals `-`, `--`, which remove bindings from a map.
    *  - Subcollection producers `keys`, `keySet`, `keysIterator`, `values`, `valuesIterator`, which return a map's keys and values separately in various forms.
    *  - Transformations `filterKeys` and `mapValues`, which produce a new map by filtering and transforming bindings of an existing map.
    *
    * Maps can be created easily:
    */
  "Maps" should "have a size method" in {
    val myMap =
      Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa")
    myMap.size should be(4)
  }

  /** Maps do not contain multiple identical pairs:
    */
  it should "not contain multiple identical pairs" in {
    val myMap = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "MI" → "Michigan")
    myMap.size should be(3)
  }

  /** Maps can be added to easily:
    */
  it should "can be added to easily" in {
    val myMap   = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "MI" → "Michigan")
    val aNewMap = myMap + ("IL" → "Illinois")
    aNewMap.contains("IL") should be(true)
  }

  /** Map values can be iterated:
    */
  it should "can be iterated" in {
    val myMap = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "MI" → "Michigan")

    val mapValues = myMap.values
    mapValues.size should be(3)
    mapValues.head should be("Michigan") //Failed presumption: The order in maps is not guaranteed

    val lastElement = mapValues.last
    lastElement should be("Wisconsin") //Failed presumption: The order in maps is not guaranteed

  }

  /** Maps may be accessed:
    */
  it should "be accessed" in {
    val myMap =
      Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa")
    myMap("MI") should be("Michigan")
    myMap("IA") should be("Iowa")
  }

  /** Maps insertion with duplicate key updates previous entry with subsequent value:
    */
  it should "insertion with duplicate key updates previous entry with subsequent value" in {
    val myMap     = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "MI" → "Meechigan")
    val mapValues = myMap.values
    mapValues.size should be(3)
    myMap("MI") should be("Meechigan")

  }

  /** Map keys may be of mixed type:
    */
  it should "have keys may be of mixed type" in {
    val myMap = Map("Ann Arbor" → "MI", 49931 → "MI")
    myMap("Ann Arbor") should be("MI")
    myMap(49931) should be("MI")
  }

  /** If a nonexistent map key is requested using `myMap(missingKey)`, a `NoSuchElementException` will be thrown.
    * Default values may be provided using either `getOrElse` or `withDefaultValue` for the entire map:
    */
  it should "return NoSuchElementException" in {
    val myMap =
      Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa")
    intercept[NoSuchElementException] {
      myMap("TX")
    }
    myMap.getOrElse("TX", "missing data") should be("missing data")

    val myMap2 = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa") withDefaultValue "missing data"
    myMap2("TX") should be("missing data")
  }

  /** Map elements can be removed easily:
    */
  it should "have elements can be removed easily" in {
    val myMap =
      Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa")
    val aNewMap = myMap - "MI"
    aNewMap.contains("MI") should be(false)
    myMap.contains("MI") should be(true)
  }

  /** Map elements can be removed in multiple:
    */
  it should "have elements can be removed in multiple" in {
    val myMap =
      Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa")
    val aNewMap = myMap -- List("MI", "OH")

    aNewMap.contains("MI") should be(false)
    myMap.contains("MI") should be(true)

    aNewMap.contains("WI") should be(true)
    aNewMap.size should be(2)
    myMap.size should be(4)
  }

  /** Map elements can be removed with a tuple:
    */
  it should "have elements can be removed with a tuple" in {
    val myMap =
      Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa")
    val aNewMap = myMap - ("MI", "WI") // Notice: single '-' operator for tuples

    aNewMap.contains("MI") should be(false)
    myMap.contains("MI") should be(true)
    aNewMap.contains("OH") should be(true)
    aNewMap.size should be(2)
    myMap.size should be(4)
  }

  /** Attempted removal of nonexistent elements from a map is handled gracefully:
    */
  it should "handle gracefully removal of nonexistent elements from a map" in {
    val myMap =
      Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa")
    val aNewMap = myMap - "MN"

    aNewMap.equals(myMap) should be(true)
  }

  /** Map equivalency is independent of order:
    */
  it should "equivalency is independent of order" in {
    val myMap1 =
      Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa")
    val myMap2 =
      Map("WI" → "Wisconsin", "MI" → "Michigan", "IA" → "Iowa", "OH" → "Ohio")

    myMap1.equals(myMap2) should be(true)
  }
  

}
