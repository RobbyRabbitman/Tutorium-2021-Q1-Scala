import org.scalatest.FunSuite
import _root_.Rational._

class CreateRationalTest extends FunSuite {
  test("Create 1/2")(createRational(1, 2))
  test("Can not create 1/0")(try {
    createRational(1, 0)
    fail("Expected to fail")
  } catch {
    case _: Exception =>
  })
}
