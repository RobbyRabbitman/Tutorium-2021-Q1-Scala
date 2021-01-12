import org.scalatest.FunSuite
import _root_.Number._

class AnswerToEveryThingTest extends FunSuite {
  test("Expect the answer to everything to be 42")(assert(ANSWER_TO_EVERYTHING === 42))
  test("Expect the answer to everything not to be 948")(assert(ANSWER_TO_EVERYTHING !== 948))

  test("Expect 43 to be greater than the answer to everything")(assert(isGreaterThanAnswerToEverything(43) === true))
  test("Expect 42 not to be greater than the answer to everything")(assert(isGreaterThanAnswerToEverything(42) === false))
  test("Expect 41 not to be greater than the answer to everything")(assert(isGreaterThanAnswerToEverything(41) === false))
}




