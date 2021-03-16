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

}
