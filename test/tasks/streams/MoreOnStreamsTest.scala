package tasks.streams

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u03.Lists.List._
import tasks.streams.MoreOnStreams._

class MoreOnStreamsTest {
  @Test def dropStreamTest(){
    val s = Stream.take(Stream.iterate(0)(_+1))(10)
    assertEquals(Cons(6, Cons(7, Cons(8, Cons(9, Nil())))), Stream.toList(Stream.drop(s)(6)))
  }

  @Test def constantStreamTest(){
    val s = Stream.toList(Stream.take(Stream.constant("x"))(5))
    assertEquals(Cons("x", Cons("x", Cons("x", Cons("x", Cons("x", Nil()))))), s)
  }

  @Test def fibonacciStreamTest(){
    val s = Stream.toList(Stream.take(Stream.fibs)(8))
    assertEquals(Cons(0, Cons(1, Cons(1, Cons(2, Cons(3, Cons(5, Cons(8, Cons(13, Nil())))))))), s)
  }



}
