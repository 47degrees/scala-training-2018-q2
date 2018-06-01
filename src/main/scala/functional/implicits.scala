package functional

import functional.datatypes._
import functional.typeclasses._
import functional.instances._

object implicits {

  implicit def intCombinator: Combinator[Int] = new IntCombinator

  implicit def maybeCombinator[A](implicit CA: Combinator[A]): Combinator[Maybe[A]] = new MaybeCombinator[A]

  implicit def maybeTransformer: Transformer[Maybe] = new MaybeTransformer

  implicit def maybeLifter: Lifter[Maybe] = new MaybeLifter

  implicit def maybeFlattener: Flattener[Maybe] = new MaybeFlattener


  //Syntax

  implicit class CombinatorSyntax[A](self: A)(implicit CA: Combinator[A]){
    def combine(b: A): A = CA.combine(self, b)
  }


  implicit class TransformerSyntax[A](self: Maybe[A])(implicit TM: Transformer[Maybe]){
    def map[B](f: A => B): Maybe[B] = TM.map(self, f)
  }

  implicit class LifterSyntax[A](self: A){
    def pure[F[_]](implicit LF: Lifter[F]): F[A] = LF.pure(self)
  }

  implicit class FlattenerSyntax[A](self: Maybe[A])(implicit FM: Flattener[Maybe]){
    def flatMap[B](f: A => Maybe[B]): Maybe[B] = FM.flatMap(self, f)
  }

}
