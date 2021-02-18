import org.scalatest.FunSuite
import _root_.ComplexRational._
import _root_.RationalNumber._

class ComplexRationalToStringTest extends FunSuite {
  test("Expect 1/2 + 0/1i to be '1 + 0i'")(assert(ToString(new ComplexRational(createRational(1, 2), createRational(0, 1))) === "1/2 + 0/1i"))
}
