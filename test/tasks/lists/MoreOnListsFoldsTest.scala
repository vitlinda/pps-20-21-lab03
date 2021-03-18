package tasks.lists

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import u03.Lists.List._
import u02.Optionals.Option._

class MoreOnListsFoldsTest {

  @Test def foldLeftTest(){
    val l = Cons(3, Cons(7, Cons(1, Cons(5, Nil()))))
    assertEquals(-16, MoreOnListsFolds.foldLeft(l)(0)(_-_))
  }

}
