import org.scalatest.FunSuite
import _root_.CharList._

class CharListLengthTest extends FunSuite {
  test("Expect length of empty list to be 0")(assert(length(EmptyCharList()) === 0))
  test("Expect length of empty list to be 1")(assert(length(NonEmptyCharList('x', EmptyCharList())) === 1))
  test("Expect length of empty list to be 2")(assert(length(NonEmptyCharList('q', NonEmptyCharList('x', EmptyCharList()))) === 2))
}

class CharListToStringTest extends FunSuite {
  test("Expect empty list to be ''")(assert(charListToString(StringToCharList("")) === ""))
  test("Expect ['x'] list to be 'x'")(assert(charListToString(StringToCharList("x")) === "x"))
  test("Expect ['x','y','z'] list to be 'xy'")(assert(charListToString(StringToCharList("xyz")) === "xyz"))
}
