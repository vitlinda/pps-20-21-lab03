package tasks.lists

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import u03.Lists._


class ListsTest {

  @Test def testDrop(){
    val l = List.Cons(10, List.Cons(20, List.Cons(30, List.Nil())))
    assertEquals(l, MoreOnLists.drop(l, 0))
    assertEquals(List.Cons(20, List.Cons(30, List.Nil())), MoreOnLists.drop(l, 1))
    assertEquals(List.Cons(30, List.Nil()), MoreOnLists.drop(l, 2))
    assertEquals(List.Nil(), MoreOnLists.drop(l, 5))
  }

  @Test def testFlatMap(){
    val l = List.Cons(10, List.Cons(20, List.Cons(30, List.Nil())))
    assertEquals(List.Cons(11, List.Cons(21, List.Cons(31, List.Nil()))), MoreOnLists.flatMap(l)(v => List.Cons(v+1, List.Nil())))
    assertEquals(List.Cons(11, List.Cons(12, List.Cons(21, List.Cons(22, List.Cons(31, List.Cons(32, List.Nil())))))), MoreOnLists.flatMap(l)(v => List.Cons(v+1, List.Cons(v+2, List.Nil()))))
  }

  @Test def mapInTermsOfFlatMapTest(){
    val l = List.Cons(10, List.Cons(20, List.Cons(30, List.Nil())))
    assertEquals(List.Cons(false, List.Cons(true, List.Cons(true, List.Nil()))), MoreOnLists.mapInTermsOfFlat(l)(_ > 10))
    assertEquals(List.Cons(11, List.Cons(21, List.Cons(31, List.Nil()))), MoreOnLists.mapInTermsOfFlat(l)(_ + 1))
  }

  @Test def filterInTermsOfFlatMapTest(){
    val l = List.Cons(10, List.Cons(20, List.Cons(30, List.Nil())))
    assertEquals(List.Cons(20, List.Cons(30, List.Nil())), MoreOnLists.filterInTermsOfFlat(l)(_ >= 20))
  }
}
