package exercises.collections

import org.scalatest._

class IterablesSpec extends FlatSpec with Matchers {

  /** The next trait from the top in the collections hierarchy is `Iterable`. All methods in this trait are defined in terms of an abstract method, `iterator`, which yields the collection's elements one by one. The `foreach` method from trait `Traversable` is implemented in `Iterable` in terms of `iterator`. Here is the actual implementation:
    *
    * {{{
    * def foreach[U](f: Elem => U): Unit = {
    * val it = iterator
    * while (it.hasNext) f(it.next())
    * }
    * }}}
    *
    * Quite a few subclasses of `Iterable` override this standard implementation of `foreach` in `Iterable`, because they can provide a more efficient implementation. Remember that `foreach` is the basis of the implementation of all operations in `Traversable`, so its performance matters.
    *
    * Some common iterables are `Set`, `List`, `Vector`, `Stacks` and `Stream`. Iterator has two important methods: `hasNext`, which answers whether the iterator has another element available, and `next` which returns the next element in the iterator.
    *
    */
  "Iterables" should "collectionIterablesIterables" in {
    val list = List(3, 5, 9, 11, 15, 19, 21)
    val it = list.iterator
    if (it.hasNext) {
      it.next should be(3)
    }
  }

  /** `grouped` will return fixed-size `Iterable` chucks of an `Iterable`:
    */
  it should "groupedIterables" in {
    val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
    val it = list grouped 3
    it.next() should be(List(3, 5, 9))
    it.next() should be(List(11, 15, 19))
    it.next() should be(List(21, 24, 32))
  }

  /** `sliding` will return an `Iterable` that shows a sliding window of an `Iterable`.
    */
  it should "slidingIterables" in {
    val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
    val it = list sliding 3
    it.next() should be(List(3, 5, 9))
    it.next() should be(List(5, 9, 11))
    it.next() should be(List(9, 11, 15))
  }

  /** `sliding` can take the size of the window as well the size of the step during each iteration:
    */
  it should "slidingWindowIterables" in {
    val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
    val it = list sliding(3, 3)
    it.next() should be(List(3, 5, 9))
    it.next() should be(List(11, 15, 19))
    it.next() should be(List(21, 24, 32))
  }

  /** `takeRight` is the opposite of 'take' in `Traversable`. It retrieves the last elements of an `Iterable`:
    */
  it should "takeRightIterables" in {
    val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
    (list takeRight 3) should be(List(21, 24, 32))
  }

  /** `dropRight` will drop a specified number of elements from the right:
    */
  it should "dropRightIterables" in {
    val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
    (list dropRight 3) should be(List(3, 5, 9, 11, 15, 19))
  }

  /** `zip` will stitch two iterables into an iterable of pairs of corresponding elements from both iterables.
    *
    * e.g. `Iterable(x1, x2, x3) zip Iterable(y1, y2, y3)` will return `((x1, y1), (x2, y2), (x3, y3))`:
    */
  it should "zipIterables" in {
    val xs = List(3, 5, 9)
    val ys = List("Bob", "Ann", "Stella")
    (xs zip ys) should be(List((3 , "Bob"), (5, "Ann"), (9, "Stella")))
  }

  /** If two Iterables aren't the same size, then `zip` will only zip what can  be paired.
    *
    * e.g. `Iterable(x1, x2, x3) zip Iterable(y1, y2)` will return `((x1, y1), (x2, y2))`:
    *
    * it should "groupedIterables" in {
    */
  it should "sameSizeZipIterables" in {
    val xs = List(3, 5, 9)
    val ys = List("Bob", "Ann")
    (xs zip ys) should be(List((3, "Bob"), (5, "Ann")))
  }

  /** If two `Iterables` aren't the same size, then `zipAll` can provide fillers for what it couldn't find a complement for.
    *
    * e.g. `Iterable(x1, x2, x3) zipAll (Iterable(y1, y2), x, y)` will return `((x1,y1), (x2, y2), (x3, y)))`:
    */
  it should "zipAllIterables" in {
    val xs = List(3, 5, 9)
    val ys = List("Bob", "Ann")
    (xs zipAll(ys, -1, "?")) should be(List((3, "Bob"), (5, "Ann"), (9, "?")))

    val xt = List(3, 5)
    val yt = List("Bob", "Ann", "Stella")
    (xt zipAll(yt, -1, "?")) should be(List((3, "Bob"), (5, "Ann"), (-1, "Stella")))

  }

  /** `zipWithIndex` will zip an `Iterable` with its integer index:
    */
  it should "zipWithIndexIterables" in {
    val xs = List("Manny", "Moe", "Jack")
    xs.zipWithIndex should be(List(("Manny", 0), ("Moe", 1), ("Jack", 2)))
  }

  /** `sameElements` will return true if the two `Iterables` produce the same elements in the same order:
    */
  it should "sameElementsIterables" in {
    val xs = List("Manny", "Moe", "Jack")
    val ys = List("Manny", "Moe", "Jack")
    (xs sameElements ys) should be(true)

    val xt = List("Manny", "Moe", "Jack")
    val yt = List("Manny", "Jack", "Moe")
    (xt sameElements yt) should be(false)

    val xs1 = Set(3, 2, 1, 4, 5, 6, 7)
    val ys1 = Set(7, 2, 1, 4, 5, 6, 3)
    (xs1 sameElements ys1) should be(true)

    val xt1 = Set(1, 2, 3)
    val yt1 = Set(3, 2, 1)
    (xt1 sameElements yt1) should be(false) // Caution - see below!
    /** Note that very small Sets (containing up to 4 elements) are implemented differently to larger Sets; as a result, their iterators produce the elements in the order that they were originally added. This causes the surprising (and arguably incorrect) behaviour in the final example above. */
  }


}
