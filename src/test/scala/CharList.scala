import org.scalatest.FunSuite
import _root_.CharList._

class CharListLengthTest extends FunSuite {
  test("Expect length of empty list to be 0")(assert(length(EmptyCharList()) === 0))
  test("Expect length of empty list to be 1")(assert(length(NonEmptyCharList('x', EmptyCharList())) === 1))
  test("Expect length of empty list to be 2")(assert(length(NonEmptyCharList('q', NonEmptyCharList('x', EmptyCharList()))) === 2))
}
