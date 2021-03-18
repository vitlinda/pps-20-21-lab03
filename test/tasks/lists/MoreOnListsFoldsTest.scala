package tasks.lists

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import u03.Lists.List._
import u02.Optionals.Option._

class MoreOnListsFoldsTest {

  @Test def foldLeftTest(){
    val l = Cons(3, Cons(7, Cons(1, Cons(5, Nil()))))
    assertEquals(-16, MoreOnListsFolds.foldLeft(l)(0)(_-_))
    assertEquals(0, MoreOnListsFolds.foldLeft(Nil[Int]())(0)(_-_))
  }

  @Test def foldRightTest(){
    val l = Cons(3, Cons(7, Cons(1, Cons(5, Nil()))))
    assertEquals(-8, MoreOnListsFolds.foldRight(l)(0)(_-_))
  }

}
