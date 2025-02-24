package tasks.lists

import scala.annotation.tailrec

object MoreOnLists {

  import u03.Lists._
  import u03.Lists.List._
  import u02.Optionals._
  import u02.Optionals.Option._

  def drop[A](l: List[A], n: Int): List[A] = (l, n) match {
    case (Cons(_, t), n) if n > 0 => drop(t, n - 1)
    case (Cons(h, t), _) => Cons(h, t)
    case _ => Nil()
  }

  def flatMap[A, B](l: List[A])(f: A => List[B]): List[B] = l match {
    case Cons(head, tail) => append(f(head), flatMap(tail)(f))
    case _ => Nil()
  }

  def mapInTermsOfFlat[A, B](l: List[A])(mapper: A => B): List[B] = flatMap(l)(x => Cons(mapper(x), Nil()))

  def filterInTermsOfFlat[A](l1: List[A])(pred: A => Boolean): List[A] = l1 match {
    case Cons(h, t) if (pred(h)) => flatMap(Cons(h, filterInTermsOfFlat(t)(pred)))(v => Cons(v, Nil()))
    case Cons(_, t) => filterInTermsOfFlat(t)(pred)
    case _ => Nil()
  }

  def max(l: List[Int]): Option[Int] = {
    @tailrec
    def _max(l: List[Int], currentMax: Int): Option[Int] = l match {
      case Cons(h, Cons(h2, tail)) => (h, h2) match {
        case (h, h2) if(h >= h2) => _max(tail, h)
        case _ => _max(tail, h2)
      }
      case Cons(h, Nil()) if (h > currentMax) => Some(h)
      case Cons(_, Nil()) => Some(currentMax)
      case Nil() => None()
    }
    _max(l, 0)
  }


}
