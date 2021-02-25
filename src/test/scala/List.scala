import _root_.List._
import org.scalatest.FunSuite

class ListLengthTest extends FunSuite {
  test("Expect length of empty list to be 0")(assert(length(EmptyList()) === 0))
  test("Expect length of empty list to be 1")(assert(length(NonEmptyList('x', EmptyList())) === 1))
  test("Expect length of empty list to be 2")(assert(length(NonEmptyList('q', NonEmptyList('x', EmptyList()))) === 2))
}

class ListAppendTest extends FunSuite {
  test("Expect [] + [] to be []")(assert(append(EmptyList(), EmptyList()) === EmptyList()))
  test("Expect [1] + [] to be [1]")(assert(append(EmptyList(), NonEmptyList(1, EmptyList())) === NonEmptyList(1, EmptyList())))
  test("Expect [] + [1] to be [1]")(assert(append(NonEmptyList(1, EmptyList()), EmptyList()) === NonEmptyList(1, EmptyList())))
  test("Expect [1,2] + [3,4] to be [1,2,3,4]")(assert(append(NonEmptyList(1, NonEmptyList(2, EmptyList())), NonEmptyList(3, NonEmptyList(4, EmptyList()))) === NonEmptyList(1, NonEmptyList(2, NonEmptyList(3, NonEmptyList(4, EmptyList()))))))
}

class ListReverseTest extends FunSuite {
  test("Expect reverse of [] to be []")(assert(reverse(EmptyList()) === EmptyList()))
  test("Expect reverse of [1] to be [1]")(assert(reverse(NonEmptyList(1, EmptyList())) === NonEmptyList(1, EmptyList())))
  test("Expect reverse of [1,2,3,4] to be [4,3,2,1]")(assert(reverse(NonEmptyList(1, NonEmptyList(2, NonEmptyList(3, NonEmptyList(4, EmptyList()))))) === NonEmptyList(4, NonEmptyList(3, NonEmptyList(2, NonEmptyList(1, EmptyList()))))))
}

class ListToStringTest extends FunSuite {
  test("Expect tostring of [] to be []")(assert(ToString(EmptyList()) === "[]"))
  test("Expect tostring of [1] to be [1]")(assert(ToString(NonEmptyList(1, EmptyList())) === "[1]"))
  test("Expect tostring of [1,2,3,4] to be [1,2,3,4]")(assert(ToString(NonEmptyList(1, NonEmptyList(2, NonEmptyList(3, NonEmptyList(4, EmptyList()))))) === "[1,2,3,4]"))
}

class ListFlattenTest extends FunSuite {
  test("Expect flatten of [] to be []")(assert(flatten(EmptyList()) === EmptyList()))
  test("Expect flatten of [[[]],[]] to be []")(assert(flatten(NonEmptyList(NonEmptyList(NonEmptyList(EmptyList(), EmptyList()), EmptyList()), NonEmptyList(EmptyList(), EmptyList()))) === EmptyList()))
  test("Expect flatten of [[[1]],[2]] to be [1,2]")(assert(flatten(NonEmptyList(NonEmptyList(NonEmptyList(1, EmptyList()), EmptyList()), NonEmptyList(2, EmptyList()))) === NonEmptyList(1, NonEmptyList(2, EmptyList()))))
}

class CreateRandomListTest extends FunSuite {
  test("Expect createRandomList(50) to have 50 elements")(assert(length(createRandomIntList()) === 50))
  test("Expect createRandomList(0) to have 0 elements")(assert(length(createRandomIntList(0)) === 0))
}

class BubbleSortTest extends FunSuite {
  test("10")(println(ToString(bubbleSort(createRandomIntList(10)))))
  test("100")(println(ToString(bubbleSort(createRandomIntList(100)))))
}
