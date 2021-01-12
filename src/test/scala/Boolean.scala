import org.scalatest.FunSuite
import _root_.Boolean._

class NandTest extends FunSuite {
  test("Expect !(true && true) to be false")(assert(nand(true, true) === false))
  test("Expect !(true && false) to be true")(assert(nand(true, false) === true))
  test("Expect !(false && true) to be true")(assert(nand(false, true) === true))
  test("Expect !(false && false) to be true")(assert(nand(false, false) === true))
}

class XorTest extends FunSuite {
  test("Expect xor(true,true) to be false")(assert(xor(true, true) === false))
  test("Expect xor(true,false) to be true")(assert(xor(true, false) === true))
  test("Expect xor(false,true) to be true")(assert(xor(false, true) === true))
  test("Expect xor(false,false) to be false")(assert(xor(false, false) === false))
}