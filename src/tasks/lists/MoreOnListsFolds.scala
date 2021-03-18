package tasks.lists

import u03.Lists._
import u03.Lists.List._

object MoreOnListsFolds {

  def foldLeft[A, B](l: List[A])(acc: B)(f: (B, A) => B): B = l match {
    case Cons(h, t) => foldLeft(t)(f(acc,h))(f)
    case _ => acc
  }

}
