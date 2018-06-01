package functional

import functional.datatypes._
import functional.typeclasses._

object instances {

  class IntCombinator extends Combinator[Int] {
    override def combine(a: Int, b: Int): Int = a + b
    override def empty: Int = 0
  }

  class MaybeCombinator[A](implicit CA: Combinator[A]) extends Combinator[Maybe[A]] {

    override def combine(a: Maybe[A], b: Maybe[A]): Maybe[A] = (a, b) match {
      case (Yes(x), Yes(y)) => Yes(CA.combine(x, y))
      case (Yes(x), No) => a
      case (No, Yes(y)) => b
      case _ => No
    }

    override def empty: Maybe[A] = No
  }

  class MaybeTransformer extends Transformer[Maybe] {
    override def map[A, B](fa: Maybe[A], f: A => B): Maybe[B] = fa match {
      case Yes(a) => Yes(f(a))
      case No => No
    }
  }

  class MaybeLifter extends MaybeTransformer with Lifter[Maybe] {
    override def pure[A](a: A): Maybe[A] = Maybe(a)
  }

  class MaybeFlattener extends MaybeLifter with Flattener[Maybe] {
    override def flatMap[A, B](fa: Maybe[A], f: A => Maybe[B]): Maybe[B] = fa match {
      case Yes(a) => f(a)
      case No => No
    }
  }

}
