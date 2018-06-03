package fp

import fp.typeclasses._
import fp.datatypes._

object instances {

  class IntCombinator extends Combinator[Int] {
    override def combine(x: Int, y: Int): Int = x + y
  }

  class MaybeCombinator[A](implicit CA: Combinator[A]) extends Combinator[Maybe[A]] {

    override def combine(x: Maybe[A], y: Maybe[A]): Maybe[A] =
      (x, y) match {
        case (Yes(xx), Yes(yy)) => Yes(CA.combine(xx, yy))
        case (Yes(xx), No) => x
        case (No, Yes(yy)) => y
        case (No, No) => No
      }

  }

  class MaybeTransformer extends Transformer[Maybe] {
    override def map[A, B](fa: Maybe[A], f: A => B): Maybe[B] = fa match {
      case Yes(a) => Maybe(f(a))
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
