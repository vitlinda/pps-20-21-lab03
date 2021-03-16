package tasks.lists

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import u02.Modules.Person
import u02.Modules.Person._
import u03.Lists.List._

class MoreOnListsPersonTest {

  @Test def coursesTest(){
    val people = Cons[Person](Student("Mario", 2021), Cons(Teacher("Maria", "SI"), Cons(Teacher("Giovanni", "SO"), Nil())))
    assertEquals(Cons("SI",Cons("SO", Nil())), MoreOnListsPerson.courses(people))
  }

}
