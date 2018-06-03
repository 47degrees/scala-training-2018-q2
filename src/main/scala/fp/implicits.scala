package fp

import fp.datatypes._
import fp.instances._
import fp.typeclasses._

object implicits {

  implicit def intCombinator: Combinator[Int] = new IntCombinator

  implicit def maybeCombinator[A](implicit CA: Combinator[A]): Combinator[Maybe[A]] = new MaybeCombinator[A]

  implicit def maybeTransformer: Transformer[Maybe] = new MaybeTransformer

  implicit def maybeLifter: Lifter[Maybe] = new MaybeLifter

  implicit def maybeFlattener: Flattener[Maybe] = new MaybeFlattener




  //SYNTAX
  implicit class CombinatorSyntax[A](self: Maybe[A]) {
    def combine(b: Maybe[A])(implicit CM: Combinator[Maybe[A]]): Maybe[A] = CM.combine(self, b)
  }

  implicit class TransformerSyntax[A](self: Maybe[A])(implicit TM: Transformer[Maybe]){
    def map[B](f: A => B): Maybe[B] = TM.map(self, f)
  }

  implicit class LifterSyntax[A](self: A){
    def pure[F[_]](implicit LF: Lifter[F]): F[A] = LF.pure(self)
  }

  implicit class LiftenerSyntax[A](self: Maybe[A])(implicit FM: Flattener[Maybe]) {
    def flatMap[B](f: A => Maybe[B]) = FM.flatMap(self, f)
  }
}
