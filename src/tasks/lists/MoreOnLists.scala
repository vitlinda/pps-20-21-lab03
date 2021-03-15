package tasks.lists

import u03.Lists


object MoreOnLists {
  import Lists._

  def drop[A](l: List[A], n: Int): List[A] = (l, n) match {
    case (List.Cons(_, tail), n) if n > 0 => drop(tail, n - 1)
    case (List.Cons(h, tail), _) => List.Cons(h, tail)
    case _ => List.Nil()

  }

}

