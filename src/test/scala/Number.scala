import org.scalatest.FunSuite
import _root_.Number._

class AnswerToEveryThingTest extends FunSuite {
  test("Expect the answer to everything to be 42")(assert(ANSWER_TO_EVERYTHING === 42))
  test("Expect the answer to everything not to be 948")(assert(ANSWER_TO_EVERYTHING !== 948))

  test("Expect 43 to be greater than the answer to everything")(assert(isGreaterThanAnswerToEverything(43) === true))
  test("Expect 42 not to be greater than the answer to everything")(assert(isGreaterThanAnswerToEverything(42) === false))
  test("Expect 41 not to be greater than the answer to everything")(assert(isGreaterThanAnswerToEverything(41) === false))
}

class SquareTest extends FunSuite {
  test("Expect square of 2 to be 4")(assert(square(2) === 4))
  test("Expect square of -2 to be 4")(assert(square(-2) === 4))
  test("Expect square of 0 to be 0")(assert(square(0) === 0))
  test("Expect square of 1 to be 1")(assert(square(1) === 1))
  test("Expect square of 0.5 to be 0.25")(assert(square(0.5) === 0.25))
  // Edge cases
  test("some test showing the limits of scala double ( and programming languages in generell)" +
    "Actually this test should fail since the square of a final number is not positive infinity")(
    assert(square(Double.MaxValue - 1) === Double.PositiveInfinity)
  )
}

class MaxTest extends FunSuite {
  test("Expect max of 1 and 2 to be 2")(assert(max(1, 2) === 2))
  test("Expect max of 2 and 1 to be 2")(assert(max(2, 1) === 2))
  test("Expect max of 0 and 0 to be 0")(assert(max(0, 0) === 0))
  test("Expect max of 1 and 1 to be 1")(assert(max(1, 1) === 1))
  test("Expect max of -1 and 0 to be 0")(assert(max(-1, 0) === 0))

  test("demo 1 showing the limits of scala (overflow). " +
    "Except max(Int.MaxValue + 1,Int.MaxValue) to be Int.MaxValue + 1, " +
    "but Int.MaxValue > Int.MaxValue + 1 (Int.MaxValue + 1 === Int.MinValue)")(
    assert(max(Int.MaxValue + 1, Int.MaxValue) === Int.MaxValue + 1))
  test("some magic aka overflow 1")(assert(Int.MaxValue + 1 === Int.MinValue))
  test("some magic aka overflow 2")(assert(Int.MinValue - 1 === Int.MaxValue))
  test("demo 2 showing the limits of scala (overflow)")(
    assert(max(Int.MinValue - 1, Int.MaxValue - 1) === Int.MaxValue - 1))
  test("demo 3 showing the limits of scala (overflow). " +
    "Except max(Int.MaxValue + 1,Int.MaxValue) to be Int.MaxValue + 1")(
    assert(max(Int.MaxValue + 1, Int.MinValue + 1) === Int.MaxValue + 1))
}

class AbsTest extends FunSuite {
  test("Expect |0| to be 0")(assert(abs(0) === 0))
  test("Expect |-0| to be 0")(assert(abs(-0) === 0))
  test("Expect |1| to be 1")(assert(abs(1) === 1))
  test("Expect |-1| to be 1")(assert(abs(-1) === 1))
  test("Expect |-123456789| to be 123456789")(assert(abs(-123456789) === 123456789))
  test("demo showing some overflow. Int range: -2147483648 to 2147483647")(assert(abs(Int.MinValue) > 0))
}

class ModuloTest extends FunSuite {
  test("Expect 46%2 to be 0")(assert(%(46, 2) === 0))
  test("Expect 13%3 to be 1")(assert(%(13, 3) === 1))
  test("Expect 0%1 to be 0")(assert(%(0, 1) === 0))
  test("Expect 46%100 to be 46")(assert(%(46, 100) === 46))
  test("Expect 46%0 to throw an exception")(assertThrows[ArithmeticException](%(46, 0)))
  test("Expect -46%-2 to be 0")(assert(%(-46, -2) === 0))
  test("Expect -13%3 to be 1")(assert(%(-13, 3) === -1))
  test("Expect -13%-3 to be 1")(assert(%(-13, -3) === -1))
  test("Expect 0%-1 to be 0")(assert(%(0, -1) === 0))
  test("Expect -46%100 to be 46")(assert(%(-46, 100) === -46))
  test("Expect -46%0 to throw an exception")(assertThrows[ArithmeticException](%(-46, 0)))
  // compare custom modulo with scala's modulo
  test("compare custom modulo -46%-2")(assert(%(-46, -2) === -46 % -2))
  test("compare custom modulo -13%3")(assert(%(-13, 3) === -13 % 3))
  test("compare custom modulo -13%-3")(assert(%(-13, -3) === -13 % -3))
  test("compare custom modulo 0%-1")(assert(%(0, -1) === 0 % -1))
  test("compare custom modulo -46%100")(assert(%(-46, 100) === -46 % 100))
  test("compare custom modulo -46%0")(assertThrows[ArithmeticException](-46 % 0))
}

class FactorialTest extends FunSuite {
  test("Expect 0! to be 1")(assert(factorial(0) === 1))
  test("Expect -1! to throw an Exception")(assertThrows[ArithmeticException](factorial(-1)))
  test("Expect 1! to be 1")(assert(factorial(1) === 1))
  test("Expect 2! to be 2")(assert(factorial(2) === 2))
  test("Expect 5! to be 120")(assert(factorial(5) === 120))
  test("Expect 20! to be 2432902008176640000")(assert(factorial(20L) === 2432902008176640000L))
}

class _FactorialTest extends FunSuite {
  test("Expect 0! to be 1")(assert(_factorial(0) === 1))
  test("Expect -1! to throw an Exception")(assertThrows[ArithmeticException](_factorial(-1)))
  test("Expect 1! to be 1")(assert(_factorial(1) === 1))
  test("Expect 2! to be 2")(assert(_factorial(2) === 2))
  test("Expect 5! to be 120")(assert(_factorial(5) === 120))
  test("Expect 20! to be 2432902008176640000")(assert(_factorial(20L) === 2432902008176640000L))
}

class PowerTest extends FunSuite {
  test("Expect 0^0 to be 1")(assert(power(0, 0) === 1))
  test("Expect 0^20 to be 0")(assert(power(0, 20) === 0))
  test("Expect 1^0 to be 1")(assert(power(1, 0) === 1))
  test("Expect 1^1 to be 1")(assert(power(1, 1) === 1))
  test("Expect 1^10 to be 1")(assert(power(1, 10) === 1))
  test("Expect 10^0 to be 1")(assert(power(10, 0) === 1))
  test("Expect 10^4 to be 10000")(assert(power(10, 4) === 10000))
  test("Expect 2^10 to be 1024")(assert(power(2, 10) === 1024))
  test("Expect 4^-1 to throw an exception")(assertThrows[IllegalArgumentException](power(4, -1)))
}

class SumOfDigitsOfSquaresTest extends FunSuite {
  test("Expect sumOfSquaresOfDigits(139) to be 91")(assert(sumOfSquaresOfDigits(139) === 91))
  test("Expect sumOfSquaresOfDigits(1111) to be 4")(assert(sumOfSquaresOfDigits(1111) === 4))
  test("Expect sumOfSquaresOfDigits(2222) to be 16")(assert(sumOfSquaresOfDigits(2222) === 16))
  test("Expect sumOfSquaresOfDigits(1000001) to be 2")(assert(sumOfSquaresOfDigits(1000001) === 2))
  test("Expect sumOfSquaresOfDigits(0) to be 0")(assert(sumOfSquaresOfDigits(0) === 0))
  test("Expect sumOfSquaresOfDigits(999999999) to be 819")(assert(sumOfSquaresOfDigits(999999999) === 729))
  test("Expect sumOfSquaresOfDigits(-11) to throw an exception")(assertThrows[IllegalArgumentException](sumOfSquaresOfDigits(-11)))
}

class InverseModule extends FunSuite {
  test("Expect inverseModule(3, 26) to be 9")(assert(inverseModule(3, 26) === Some(9)))
  test("Expect inverseModule(3, 27) to not exist")(assert(inverseModule(3, 27) === None))
  test("Expect inverseModule(42, 2017) to be 1969")(assert(inverseModule(42, 2017) === Some(1969)))
}

class ExtendedEuclidAlgorithmTest extends FunSuite {
  test("Expect extendedEuclidAlgorithm(120, 23) to be (1,-9,47)")(assert(extendedEuclidAlgorithm(120, 23) === (1, -9, 47)))
  test("Expect extendedEuclidAlgorithm(122, 22) to be (2,2,-11)")(assert(extendedEuclidAlgorithm(122, 22) === (2, 2, -11)))
  test("Expect extendedEuclidAlgorithm(99, 78) to be (3,-11,14)")(assert(extendedEuclidAlgorithm(99, 78) === (3, -11, 14)))
}


