
import org.scalatest.FunSuite
import _root_.Boolean2._

class andTest extends FunSuite {
  test("Expect true & true to be true")(assert(and(True(), True()) === True()))
  test("Expect true & false to be false")(assert(and(True(), False()) === False()))
  test("Expect false & true to be false")(assert(and(False(), True()) === False()))
  test("Expect false & false to be false")(assert(and(False(), False()) === False()))
}

class orTest extends FunSuite {
  test("Expect true | true to be true")(assert(or(True(), True()) === True()))
  test("Expect true | false to be true")(assert(or(True(), False()) === True()))
  test("Expect false | true to be true")(assert(or(False(), True()) === True()))
  test("Expect false | false to be false")(assert(or(False(), False()) === False()))
}

class xorTest extends FunSuite {
  test("Expect true xor true to be false")(assert(xor(True(), True()) === False()))
  test("Expect true xor false to be true")(assert(xor(True(), False()) === True()))
  test("Expect false xor true to be true")(assert(xor(False(), True()) === True()))
  test("Expect false xor false to be false")(assert(xor(False(), False()) === False()))
}

class impliesTest extends FunSuite {
  test("Expect true implies true to be true")(assert(implies(True(), True()) === True()))
  test("Expect true implies false to be false")(assert(implies(True(), False()) === False()))
  test("Expect false implies true to be true")(assert(implies(False(), True()) === True()))
  test("Expect false implies false to be true")(assert(implies(False(), False()) === True()))
}

class isEqualTest extends FunSuite {
  test("Expect true isEqual true to be true")(assert(isEqual(True(), True()) === True()))
  test("Expect true isEqual false to be false")(assert(isEqual(True(), False()) === False()))
  test("Expect false isEqual true to be false")(assert(isEqual(False(), True()) === False()))
  test("Expect false isEqual false to be true")(assert(isEqual(False(), False()) === True()))
}

class nandTest extends FunSuite {
  test("Expect !(true & true) to be false")(assert(nand(True(), True()) === False()))
  test("Expect !(true & false) to be true")(assert(nand(True(), False()) === True()))
  test("Expect !(false & true) to be true")(assert(nand(False(), True()) === True()))
  test("Expect !(false & false) to be true")(assert(nand(False(), False()) === True()))
}