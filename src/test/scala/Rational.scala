import org.scalatest.FunSuite
import _root_.RationalNumber._

class CreateRationalTest extends FunSuite {
  test("Create 1/2")(createRational(1, 2))
  test("Can not create 1/0")(try {
    createRational(1, 0)
    fail("Expected to fail")
  } catch {
    case _: Exception =>
  })
}

class ToDivStringTest extends FunSuite {
  test("Expect 1/2 to be '1/2'")(assert(toDivString(createRational(1, 2)) === "1/2"))
  test("Expect -1/2 to be '-1/2'")(assert(toDivString(createRational(-1, 2)) === "-1/2"))
  test("Expect 1/-2 to be '-1/2'")(assert(toDivString(createRational(1, -2)) === "-1/2"))
  test("Expect -1/-2 to be '1/2'")(assert(toDivString(createRational(-1, -2)) === "1/2"))
}

class ToCanonicalTest extends FunSuite {
  test("Expect 1/2 to be 1/2")(assert(toCanonical(new RationalNumber(1, 2)) === new RationalNumber(1, 2)))
  test("Expect 2/4 to be 1/2")(assert(toCanonical(new RationalNumber(2, 4)) === new RationalNumber(1, 2)))
  test("Expect -1/2 to be -1/2")(assert(toCanonical(new RationalNumber(-1, 2)) === new RationalNumber(-1, 2)))
  test("Expect 1/-2 to be -1/2")(assert(toCanonical(new RationalNumber(1, -2)) === new RationalNumber(-1, 2)))
  test("Expect -1/-2 to be 1/2")(assert(toCanonical(new RationalNumber(-1, -2)) === new RationalNumber(1, 2)))
  test("Expect -2/4 to be -1/2")(assert(toCanonical(new RationalNumber(-2, 4)) === new RationalNumber(-1, 2)))
  test("Expect 2/-4 to be -1/2")(assert(toCanonical(new RationalNumber(2, -4)) === new RationalNumber(-1, 2)))
  test("Expect -2/-4 to be 1/2")(assert(toCanonical(new RationalNumber(-2, -4)) === new RationalNumber(1, 2)))
}

class SameValueTest extends FunSuite {
  test("Expect 1/2 to be 2/4")(assert(sameValue(createRational(1, 2), createRational(2, 4))))
  test("Expect -1/-2 to be 2/4")(assert(sameValue(createRational(-1, -2), createRational(2, 4))))
  test("Expect -1/2 not to be 2/4")(assert(!sameValue(createRational(-1, 2), createRational(2, 4))))
  test("Expect 1/2 not to be -2/4")(assert(!sameValue(createRational(1, 2), createRational(-2, 4))))
}

class LessRationalTest extends FunSuite {
  test("Expect 1/2 to be less than 3/4")(assert(less(createRational(1, 2), createRational(3, 4))))
  test("Expect -1/2 to be less than 3/4")(assert(less(createRational(-1, 2), createRational(3, 4))))
  test("Expect 1/2 not to be less than 3/-4")(assert(!less(createRational(1, 2), createRational(3, -4))))
  test("Expect 1/2 not to be less than -3/4")(assert(!less(createRational(1, 2), createRational(-3, 4))))
  test("Expect 1/2 not to be less than 2/4")(assert(!less(createRational(1, 2), createRational(2, 4))))
  test("Expect 1/2 not to be less than 2/11")(assert(!less(createRational(1, 2), createRational(2, 11))))
}

class AddRationalTest extends FunSuite {
  test("Expect 1/2 + 1/2 to be 1/1")(assert(add(createRational(1, 2), createRational(1, 2)) === createRational(1, 1)))
  test("Expect -1/2 + 1/2 to be 0/1")(assert(add(createRational(-1, 2), createRational(1, 2)) === createRational(0, 1)))
  test("Expect 1/2 + -1/2 to be 0/1")(assert(add(createRational(1, 2), createRational(-1, 2)) === createRational(0, 1)))
  test("Expect 1/2 + 3/4 to be 5/4")(assert(add(createRational(1, 2), createRational(3, 4)) === createRational(5, 4)))
}

class SubRationalTest extends FunSuite {
  test("Expect 1/2 - 1/2 to be 0/1")(assert(sub(createRational(1, 2), createRational(1, 2)) === createRational(0, 1)))
  test("Expect -1/2 - 1/2 to be -1/1")(assert(sub(createRational(-1, 2), createRational(1, 2)) === createRational(-1, 1)))
  test("Expect 1/2 - -1/2 to be 1/1")(assert(sub(createRational(1, 2), createRational(-1, 2)) === createRational(1, 1)))
  test("Expect 1/2 - 3/4 to be -1/4")(assert(sub(createRational(1, 2), createRational(3, 4)) === createRational(-1, 4)))
}

class MultRationalTest extends FunSuite {
  test("Expect 1/2 * 1/2 to be 1/4")(assert(mult(createRational(1, 2), createRational(1, 2)) === createRational(1, 4)))
  test("Expect -1/2 * 1/2 to be -1/4")(assert(mult(createRational(-1, 2), createRational(1, 2)) === createRational(-1, 4)))
  test("Expect 1/2 * -1/2 to be -1/4")(assert(mult(createRational(1, 2), createRational(-1, 2)) === createRational(-1, 4)))
  test("Expect 1/2 * 0/1 to be 0/1")(assert(mult(createRational(1, 2), createRational(0, 1)) === createRational(0, 1)))
}

class DivideRationalTest extends FunSuite {
  test("Expect 1/2 / 1/2 to be 1/1")(assert(divide(createRational(1, 2), createRational(1, 2)) === createRational(1, 1)))
  test("Expect -1/2 / 1/2 to be -1/1")(assert(divide(createRational(-1, 2), createRational(1, 2)) === createRational(-1, 1)))
  test("Expect 1/2 / -1/2 to be -1/1")(assert(divide(createRational(1, 2), createRational(-1, 2)) === createRational(-1, 1)))
  test("Expect 1/2 / 0/1 to throw an exception")(assertThrows[ArithmeticException](divide(createRational(1, 2), createRational(0, 1))))
}