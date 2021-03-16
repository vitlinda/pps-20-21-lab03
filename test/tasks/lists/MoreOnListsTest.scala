package tasks.lists

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import u03.Lists._
import u03.Lists.List._
import u02.Optionals._
import u02.Optionals.Option._


class MoreOnListsTest {

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

  @Test def maxTest(){
    val l = Cons(10, Cons(25, Cons(20, Nil())))
    assertEquals(Some(25), MoreOnLists.max(l))

    val l1 = Cons(10, Cons(20, Cons(30, Nil())))
    assertEquals(Some(30), MoreOnLists.max(l1))

    assertEquals(None(), MoreOnLists.max(Nil()))
  }



}
