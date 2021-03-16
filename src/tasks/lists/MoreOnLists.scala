package tasks.lists

import u03.Lists

object MoreOnLists {
  import Lists._

  def drop[A](l: List[A], n: Int): List[A] = (l, n) match {
    case (List.Cons(_, t), n) if n > 0 => drop(t, n - 1)
    case (List.Cons(h, t), _) => List.Cons(h, t)
    case _ => List.Nil()
  }

  def flatMap[A, B](l: List[A])(f: A => List[B]): List[B] = l match {
    case List.Cons(head, tail) => List.append(f(head), flatMap(tail)(f))
    case _ => List.Nil()
  }

  def mapInTermsOfFlat[A,B](l: List[A])(mapper: A => B): List[B] = flatMap(l)(x => List.Cons(mapper(x), List.Nil()))

  def filterInTermsOfFlat[A](l1: List[A])(pred: A => Boolean): List[A] = l1 match {
    case List.Cons(h, t) if (pred(h)) => flatMap(List.Cons(h, filterInTermsOfFlat(t)(pred)))(v => List.Cons(v, List.Nil()))
    case List.Cons(_, t) => filterInTermsOfFlat(t)(pred)
    case _ => List.Nil()
  }

}
