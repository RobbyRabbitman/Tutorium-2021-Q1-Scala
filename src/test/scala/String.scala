import org.scalatest.FunSuite
import _root_.String._

class ReverseTest extends FunSuite {
  test("Expect reverse of '' to be ''")(assert(reverse("") === ""))
  test("Expect reverse of 'a' to be 'a'")(assert(reverse("a") === "a"))
  test("Expect reverse of 'ab' to be 'ba'")(assert(reverse("ab") === "ba"))
  test("Expect reverse of 'a b' to be 'a b'")(assert(reverse("a b") === "b a"))
  test("Expect reverse of 'a   bc' to be 'cb   a'")(assert(reverse("a  bc") === "cb  a"))
  test("Expect reverse of 'abcd' to be 'dcba'")(assert(reverse("abcd") === "dcba"))
  test("Expect reverse of ' ' to be ' '")(assert(reverse(" ") === " "))
}

class RepeatTest extends FunSuite {
  test("Expect 'Hello' repeated 3 times to be 'HelloHelloHello'")(assert(repeat("Hello", 3) === "HelloHelloHello"))
  test("Expect 'Hello' repeated 0 times to be ''")(assert(repeat("Hello", 0) === ""))
  test("Expect 'Hello' repeated -1 times to be ''")(assert(repeat("Hello", -1) === ""))
  test("Expect 'Hello' repeated 1 times to be 'Hello'")(assert(repeat("Hello", 1) === "Hello"))
}

class ContainsHowOftenTest extends FunSuite {
  test("Expect aaa to contain a 3 times")(assert(containsHowOften("aaa", "a") === 3))
  test("Expect aa a to contain a 3 times")(assert(containsHowOften("aa a", "a") === 3))
  test("Expect '' to contain a 0 times")(assert(containsHowOften("", "a") === 0))
  test("Expect '' to contain '' 0 times")(assert(containsHowOften("aaa", "a") === 3))
  test("Expect '   ' to contain '   ' 3 times")(assert(containsHowOften("   ", " ") === 3))
  test("Expect aaa to contain '' 0 times")(assert(containsHowOften("aaa", "") === 0))
}

class SwapAtTest extends FunSuite {
  test("Expect swapping of 'Hello World' at ' ' to be 'World Hello'")(assert(swapAt("Hello World", ' ') === "World Hello"))
  test("Expect swapping of 'Hello World' at 'x' to be 'World Hello'")(assert(swapAt("Hello World", 'x') === "Hello World"))
  test("Expect swapping of 'Hello World' at 'H' to be 'World Hello'")(assert(swapAt("Hello World", 'H') === "ello WorldH"))
  test("Expect swapping of 'Hello World' at 'l' to be 'lo WorldlHe'")(assert(swapAt("Hello World", 'l') === "lo WorldlHe"))
  test("Expect swapping of 'aabbcc' at 'b' to be 'bccbaa'")(assert(swapAt("aabbcc", 'b') === "bccbaa"))
}

class ShiftTest extends FunSuite {
  test("Expect shift of 'Hello' to 'oHell'")(assert(shift("Hello") === "oHell"))
  test("Expect shift of 'H' to 'H'")(assert(shift("H") === "H"))
  test("Expect shift of 'H ' to ' H'")(assert(shift("H ") === " H"))
  test("Expect shift of '' to ''")(assert(shift("") === ""))
}

class ShiftBackTest extends FunSuite {
  test("Expect shift back of 'Hello' to 'oHell'")(assert(shiftBack("Hello") === "elloH"))
  test("Expect shift back of 'H' to 'H'")(assert(shiftBack("H") === "H"))
  test("Expect shift back of 'H ' to ' H'")(assert(shiftBack("H ") === " H"))
  test("Expect shift back of '' to ''")(assert(shiftBack("") === ""))
}

class LessTest extends FunSuite {
  test("Expect less('','') to be false ")(assert(less("", "") === false))
  test("Expect less('',' ') to be true ")(assert(less("", " ") === true))
  test("Expect less(' ','') to be false ")(assert(less(" ", "") === false))
  test("Expect less(' ',' ') to be false ")(assert(less(" ", " ") === false))
  test("Expect less('a','a') to be false ")(assert(less("a", "a") === false))
  test("Expect less('a','b') to be true ")(assert(less("a", "b") === true))
  test("Expect less('A','a') to be true ")(assert(less("A", "a") === true))
  test("Expect less('aa','a') to be false ")(assert(less("aa", "a") === false))
  test("Expect less('a','') to be false ")(assert(less("a", "") === false))
  test("Expect less('a',' ') to be false ")(assert(less("a", " ") === false))
  test("Expect less('aa',' aaa') to be true ")(assert(less("aa", "aaa") === true))
  test("Expect less('bb',' aaa') to be false ")(assert(less("bb", "aaa") === false))
}

class ToStringTest extends FunSuite {
  test("Expect toString(true) to be 'true'")(assert(ToString(true) === "true"))
  test("Expect toString(false) to be 'false'")(assert(ToString(false) === "false"))
  test("Expect toString('some string') to be 'some string'")(assert(ToString("some string") === "some string"))
  test("Expect toString('') to be ''")(assert(ToString("") === ""))
  test("Expect toString(0) to be '0'")(assert(ToString(0) === "0"))
  test("Expect toString(1) to be '1'")(assert(ToString(1) === "1"))
  test("Expect toString(-1) to be '-1'")(assert(ToString(-1) === "-1"))
  test("Expect toString(123456) to be '123456'")(assert(ToString(123456) === "123456"))
}
