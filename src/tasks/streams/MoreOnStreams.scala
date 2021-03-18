package tasks.streams

import u03.Lists

object MoreOnStreams {
  import Lists._
  sealed trait Stream[A]
  object Stream {

    private case class Empty[A]() extends Stream[A]
    private case class Cons[A](head: () => A, tail: () => Stream[A]) extends Stream[A]

    def empty[A](): Stream[A] = Empty()

    def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
      lazy val head = hd
      lazy val tail = tl
      Cons(() => head, () => tail)
    }
    def toList[A](stream: Stream[A]): List[A] = stream match {
      case Cons(h,t) => List.Cons(h(), toList(t()))
      case _ => List.Nil()
    }

    def map[A, B](stream: Stream[A])(f: A => B): Stream[B] = stream match {
      case Cons(head, tail) => cons(f(head()), map(tail())(f))
      case _ => Empty()
    }

    def filter[A](stream: Stream[A])(pred: A => Boolean): Stream[A] = stream match {
      case Cons(head, tail) if (pred(head())) => cons(head(), filter(tail())(pred))
      case Cons(head, tail) => filter(tail())(pred)
      case _ => Empty()
    }

    def take[A](stream: Stream[A])(n: Int): Stream[A] = (stream,n) match {
      case (Cons(head, tail), n) if n>0 => cons(head(), take(tail())(n - 1))
      case _ => Empty()
    }

    def iterate[A](init: => A)(next: A => A): Stream[A] = cons(init, iterate(next(init))(next))

    def drop[A](stream: Stream[A])(n: Int): Stream[A] = (stream, n) match {
      case (Cons(h, tail), n) if n > 0 => drop(tail())(n - 1)
      case (Cons(head, t), _) => cons(head(), t())
      case _ => Empty()
    }

    def constant[A](k: A): Stream[A] = cons(k, constant(k))


  }


}
