package tasks.lists

import u03.Lists._
import u03.Lists.List._

import scala.annotation.tailrec

object MoreOnListsFolds {

  @tailrec
  def foldLeft[A, B](l: List[A])(acc: B)(f: (B, A) => B): B = l match {
    case Cons(h, t) => foldLeft(t)(f(acc,h))(f)
    case _ => acc
  }

  def foldRight[A, B](l: List[A])(acc: B)(f: (A, B) => B): B = l match {
    case Cons(h, t) => f(h, foldRight(t)(acc)(f))
    case _ => acc
  }

}
