package tasks.lists

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import u03.Lists._
import u03.Lists.List._


class ListsTest {

  @Test def testDrop(){
    val l = Cons(10, Cons(20, Cons(30, Nil())))
    assertEquals(l, MoreOnLists.drop(l, 0))
    assertEquals(Cons(20, Cons(30, Nil())), MoreOnLists.drop(l, 1))
    assertEquals(Cons(30, Nil()), MoreOnLists.drop(l, 2))
    assertEquals(Nil(), MoreOnLists.drop(l, 5))
  }

  @Test def testFlatMap(){
    val l = Cons(10, Cons(20, Cons(30, Nil())))
    assertEquals(Cons(11, Cons(21, Cons(31, Nil()))), MoreOnLists.flatMap(l)(v => Cons(v+1, Nil())))
    assertEquals(Cons(11, Cons(12, Cons(21, Cons(22, Cons(31, Cons(32, Nil())))))), MoreOnLists.flatMap(l)(v => Cons(v+1, Cons(v+2, Nil()))))
  }

  @Test def mapInTermsOfFlatMapTest(){
    val l = Cons(10, Cons(20, Cons(30, Nil())))
    assertEquals(Cons(false, Cons(true, Cons(true, Nil()))), MoreOnLists.mapInTermsOfFlat(l)(_ > 10))
    assertEquals(Cons(11, Cons(21, Cons(31, Nil()))), MoreOnLists.mapInTermsOfFlat(l)(_ + 1))
  }

  @Test def filterInTermsOfFlatMapTest(){
    val l = Cons(10, Cons(20, Cons(30, Nil())))
    assertEquals(Cons(20, Cons(30, Nil())), MoreOnLists.filterInTermsOfFlat(l)(_ >= 20))
  }



}
