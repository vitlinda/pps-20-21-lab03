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

    def takeWhile[A](stream: Stream[A])(pred: A => Boolean): Stream[A] = stream match {
      case Cons(fh,ft) if (pred(fh()))=> cons(fh(),takeWhile(ft())(pred))
      case _ => empty()
    }

    def peek[A](stream: Stream[A])(exec: A => Unit): Stream[A] = map(stream)(x => {exec(x);x})

    def fold[A, B](stream: Stream[A])(base: => B)(op: (A, B) => B): B = stream match {
      case Cons(fh,ft) => op(fh(),fold(ft())(base)(op))
      case Empty() => base
    }

    def iterate[A](seed: => A)(next: A => A): Stream[A] = cons(seed, iterate(next(seed))(next))

    def generate[A](elem: => A): Stream[A] = iterate(elem)(x=>x)

    def drop[A](stream: Stream[A])(n: Int): Stream[A] = (stream, n) match {
      case (Cons(_, tail), n) if n > 0 => drop(tail())(n - 1)
      case (Cons(head, t), _) => cons(head(), t())
      case _ => Empty()
    }

    def constant[A](k: A): Stream[A] = cons(k, constant(k))

    def fibs: Stream[Int] = {
      def _fibs(x1: Int, x2: Int): Stream[Int] = {
         cons(x1, _fibs(x2, x1 + x2))
      }
      _fibs(0,1)
    }

  }


}
