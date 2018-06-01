package functional


object typeclasses {

  trait Combinator[A] {
    def combine(a: A, b: A): A
    def empty: A
  }


  trait Transformer[F[_]] {
    def map[A, B](fa: F[A], f: A => B): F[B]
  }


  trait Lifter[F[_]] extends Transformer[F] {
    def pure[A](a: A): F[A]
  }

  trait Flattener[F[_]] extends Lifter[F] {
    def flatMap[A, B](fa: F[A], f: A => F[B]): F[B]
  }


}
