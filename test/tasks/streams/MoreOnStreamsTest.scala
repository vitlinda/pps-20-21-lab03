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

}
