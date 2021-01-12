import org.scalatest.FunSuite
import _root_.Boolean._

class NandTest extends FunSuite {
  test("Expect !(true && true) to be false")(assert(nand(true,true) === false))
  test("Expect !(true && false) to be true")(assert(nand(true,false) === true))
  test("Expect !(false && true) to be true")(assert(nand(false,true) === true))
  test("Expect !(false && false) to be true")(assert(nand(false,false) === true))
}
