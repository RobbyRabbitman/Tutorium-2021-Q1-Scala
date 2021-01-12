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




