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

class ContainsHowOften extends FunSuite {
  test("Expect aaa to contain a 3 times")(assert(containsHowOften("aaa", "a") === 3))
  test("Expect aa a to contain a 3 times")(assert(containsHowOften("aa a", "a") === 3))
  test("Expect '' to contain a 0 times")(assert(containsHowOften("", "a") === 0))
  test("Expect '' to contain '' 0 times")(assert(containsHowOften("aaa", "a") === 3))
  test("Expect '   ' to contain '   ' 3 times")(assert(containsHowOften("   ", " ") === 3))
  test("Expect aaa to contain '' 0 times")(assert(containsHowOften("aaa", "") === 0))
}