package tasks.lists

import u02.Modules.Person
import u02.Modules.Person._

object MoreOnListsPerson {
  import u03.Lists._
  import u03.Lists.List._

  def courses(people: List[Person]): List[String] = MoreOnLists.flatMap(people)(p => p match {
    case Teacher(_, course) => Cons(course, Nil())
    case _ => Nil()
  })


}
