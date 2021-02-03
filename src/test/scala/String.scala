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