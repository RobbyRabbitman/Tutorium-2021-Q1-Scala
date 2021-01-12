import org.scalatest.FunSuite
import _root_.Number._

class AnswerToEveryThingTest extends FunSuite {
  test("Expect the answer to everything to be 42")(assert(ANSWER_TO_EVERYTHING === 42))
  test("Expect the answer to everything not to be 948")(assert(ANSWER_TO_EVERYTHING !== 948))

  test("Expect 43 to be greater than the answer to everything")(assert(isGreaterThanAnswerToEverything(43) === true))
  test("Expect 42 not to be greater than the answer to everything")(assert(isGreaterThanAnswerToEverything(42) === false))
  test("Expect 41 not to be greater than the answer to everything")(assert(isGreaterThanAnswerToEverything(41) === false))
}

class SquareTest extends FunSuite {
  test("Expect square of 2 to be 4")(assert(square(2) === 4))
  test("Expect square of -2 to be 4")(assert(square(-2) === 4))
  test("Expect square of 0 to be 0")(assert(square(0) === 0))
  test("Expect square of 1 to be 1")(assert(square(1) === 1))
  test("Expect square of 0.5 to be 0.25")(assert(square(0.5) === 0.25))
  // Edge cases
  test("some test showing the limits of scala double ( and programming languages in generell)" +
    "Actually this test should fail since the square of a final number is not positive infinity")(
    assert(square(Double.MaxValue - 1) === Double.PositiveInfinity)
  )
}

class MaxTest extends FunSuite {
  test("Expect max of 1 and 2 to be 2")(assert(max(1, 2) === 2))
  test("Expect max of 2 and 1 to be 2")(assert(max(2, 1) === 2))
  test("Expect max of 0 and 0 to be 0")(assert(max(0, 0) === 0))
  test("Expect max of 1 and 1 to be 1")(assert(max(1, 1) === 1))
  test("Expect max of -1 and 0 to be 0")(assert(max(-1, 0) === 0))

  test("demo 1 showing the limits of scala (overflow). " +
    "Except max(Int.MaxValue + 1,Int.MaxValue) to be Int.MaxValue + 1, " +
    "but Int.MaxValue > Int.MaxValue + 1 (Int.MaxValue + 1 === Int.MinValue)")(
    assert(max(Int.MaxValue + 1, Int.MaxValue) === Int.MaxValue + 1))
  test("some magic aka overflow 1")(assert(Int.MaxValue + 1 === Int.MinValue))
  test("some magic aka overflow 2")(assert(Int.MinValue - 1 === Int.MaxValue))
  test("demo 2 showing the limits of scala (overflow)")(
    assert(max(Int.MinValue - 1, Int.MaxValue - 1) === Int.MaxValue - 1))
  test("demo 3 showing the limits of scala (overflow). " +
    "Except max(Int.MaxValue + 1,Int.MaxValue) to be Int.MaxValue + 1")(
    assert(max(Int.MaxValue + 1, Int.MinValue + 1) === Int.MaxValue + 1))
}

class AbsTest extends FunSuite {
  test("Expect |0| to be 0")(assert(abs(0) === 0))
  test("Expect |-0| to be 0")(assert(abs(-0) === 0))
  test("Expect |1| to be 1")(assert(abs(1) === 1))
  test("Expect |-1| to be 1")(assert(abs(-1) === 1))
  test("Expect |-123456789| to be 123456789")(assert(abs(-123456789) === 123456789))
  test("demo showing some overflow. Int range: -2147483648 to 2147483647")(assert(abs(Int.MinValue) > 0))

}




