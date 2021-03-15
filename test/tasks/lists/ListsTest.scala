package tasks.lists

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import u03.Lists._


class ListsTest {

  @Test def testDrop(){
    val l = List.Cons(10, List.Cons(20, List.Cons(30, List.Nil())))
    assertEquals(List.Cons(20, List.Cons(30, List.Nil())), MoreOnLists.drop(l, 1))
    assertEquals(List.Cons(30, List.Nil()), MoreOnLists.drop(l, 2))
    assertEquals(List.Nil(), MoreOnLists.drop(l, 5))
  }

}
