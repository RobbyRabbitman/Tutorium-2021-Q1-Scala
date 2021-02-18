import org.scalatest.FunSuite
import _root_.Number._
import _root_.RationalNumber._
import _root_.ComplexRational._

class AnswerToEveryThingTest extends FunSuite {
  test("Expect the answer to everything to be 42")(assert(ANSWER_TO_EVERYTHING === 42))
  test("Expect the answer to everything not to be 948")(assert(ANSWER_TO_EVERYTHING !== 948))

  test("Expect 43 to be greater than the answer to everything")(assert(isGreaterThanAnswerToEverything(43) === true))
  test("Expect 42 not to be greater than the answer to everything")(assert(isGreaterThanAnswerToEverything(42) === false))
  test("Expect 41 not to be greater than the answer to everything")(assert(isGreaterThanAnswerToEverything(41) === false))
}

class AddOneTest extends FunSuite {
  test("Expect 0 + 1 to be 1")(assert(addOne(0) === 1))
  test("Expect -1 + 1 to be 0")(assert(addOne(-1) === 0))
  test("Expect 1 + 1 to be 2")(assert(addOne(1) === 2))
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

class _PowerTest extends FunSuite {
  test("Expect 0^0 to be 1")(assert(_power(0, 0) === 1))
  test("Expect 0^20 to be 0")(assert(_power(0, 20) === 0))
  test("Expect 1^0 to be 1")(assert(_power(1, 0) === 1))
  test("Expect 1^1 to be 1")(assert(_power(1, 1) === 1))
  test("Expect 1^10 to be 1")(assert(_power(1, 10) === 1))
  test("Expect 10^0 to be 1")(assert(_power(10, 0) === 1))
  test("Expect 10^4 to be 10000")(assert(_power(10, 4) === 10000))
  test("Expect 2^10 to be 1024")(assert(_power(2, 10) === 1024))
  test("Expect 4^-1 to throw an exception")(assertThrows[IllegalArgumentException](_power(4, -1)))
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

class FibTest extends FunSuite {
  test("Expect fib(0) to be 0")(assert(fib(0) === 0))
  test("Expect fib(1) to be 1")(assert(fib(1) === 1))
  test("Expect fib(2) to be 1")(assert(fib(2) === 1))
  test("Expect fib(3) to be 2")(assert(fib(3) === 2))
  test("Expect fib(4) to be 3")(assert(fib(4) === 3))
  test("Expect fib(5) to be 5")(assert(fib(5) === 5))
  test("Expect fib(6) to be 8")(assert(fib(6) === 8))
  test("Expect fib(-1) to be throw an Exception")(assertThrows[IllegalArgumentException](fib(-1)))
}

class IsPrimeTest extends FunSuite {
  test("Expect 2 to be a prime number")(assert(isPrime(2)))
  test("Expect 3 to be a prime number")(assert(isPrime(3)))
  test("Expect 4 to not be a prime number")(assert(!isPrime(4)))
  test("Expect 5 to be a prime number")(assert(isPrime(5)))
  test("Expect 11 to be a prime number")(assert(isPrime(11)))
  test("Expect 27 to not be a prime number")(assert(!isPrime(27)))
  test("Expect 33 to not be a prime number")(assert(!isPrime(33)))
  test("Expect 41 to be a prime number")(assert(isPrime(41)))
  test("Expect 1 to throw an Exception")(assertThrows[IllegalArgumentException](isPrime(1)))
}

class GcdTest extends FunSuite {
  test("Expect gcd(3,9) to be 3")(assert(gcd(3, 9) === 3))
  test("Expect gcd(-3,9) to be 3")(assert(gcd(-3, 9) === 3))
  test("Expect gcd(3,-9) to be 3")(assert(gcd(3, -9) === 3))
  test("Expect gcd(-3,-9) to be 3")(assert(gcd(-3, -9) === 3))
  test("Expect gcd(20,50) to be 3")(assert(gcd(20, 50) === 10))
  test("Expect gcd(0,0) to be 0")(assert(gcd(0, 0) === 0))
  test("Expect gcd(0,1000) to be 1000")(assert(gcd(0, 1000) === 1000))
  test("Expect gcd(10,1000) to be gcd(1000,10) ")(assert(gcd(10, 1000) === gcd(1000, 10)))
}

class LcmTest extends FunSuite {
  test("Expect lcm(3,9) to be 9")(assert(lcm(3, 9) === 9))
  test("Expect lcm(-3,9) to be 9")(assert(lcm(-3, 9) === 9))
  test("Expect lcm(3,-9) to be 9")(assert(lcm(3, -9) === 9))
  test("Expect lcm(-3,-9) to be 9")(assert(lcm(-3, -9) === 9))
  test("Expect lcm(20,50) to be 3")(assert(lcm(20, 50) === 100))
  test("Expect lcm(0,0) to be 0")(assert(lcm(0, 0) === 0))
  test("Expect lcm(0,1000) to be 1000")(assert(lcm(0, 1000) === 0))
  test("Expect lcm(10,1000) to be lcm(1000,10) ")(assert(lcm(10, 1000) === lcm(1000, 10)))
}

class MirrorTest extends FunSuite {
  test("Expect mirror of 1 to be 1")(assert(mirror(1) === 1))
  test("Expect mirror of 0 to be 0")(assert(mirror(0) === 0))
  test("Expect mirror of 10 to be 1")(assert(mirror(10) === 1))
  test("Expect mirror of 100 to be 1")(assert(mirror(100) === 1))
  test("Expect mirror of 1000 to be 1")(assert(mirror(1000) === 1))
  test("Expect mirror of 321 to be 123")(assert(mirror(321) === 123))
  test("Expect mirror of 123456789 to be 987654321")(assert(mirror(123456789) === 987654321))
  test("Expect mirror of 1234567890 to be 987654321")(assert(mirror(1234567890) === 987654321))
  test("Expect mirror of 101 to be 101")(assert(mirror(101) === 101))
  test("Expect mirror of 1001 to be 1001")(assert(mirror(1001) === 1001))
  test("Expect mirror of -1 to throw an Exception")(assertThrows[IllegalArgumentException](mirror(-1)))
}

class _MirrorTest extends FunSuite {
  test("Expect _mirror of 0 to be 0")(assert(_mirror(0) === 0))
  test("Expect _mirror of 1 to be 1")(assert(_mirror(1) === 1))
  test("Expect _mirror of 10 to be 1")(assert(_mirror(10) === 1))
  test("Expect _mirror of 100 to be 1")(assert(_mirror(100) === 1))
  test("Expect _mirror of 1000 to be 1")(assert(_mirror(1000) === 1))
  test("Expect _mirror of 321 to be 123")(assert(_mirror(321) === 123))
  test("Expect _mirror of 123456789 to be 987654321")(assert(_mirror(123456789) === 987654321))
  test("Expect _mirror of 1234567890 to be 987654321")(assert(_mirror(1234567890) === 987654321))
  test("Expect _mirror of 101 to be 101")(assert(_mirror(101) === 101))
  test("Expect _mirror of 1001 to be 1001")(assert(_mirror(1001) === 1001))
  test("Expect _mirror of -1 to throw an Exception")(assertThrows[IllegalArgumentException](_mirror(-1)))
}

class ToOctalTest extends FunSuite {
  test("Expect 0(10) to be 0(8)")(assert(toOctal(0) === 0))
  test("Expect 1(10) to be 1(8)")(assert(toOctal(1) === 1))
  test("Expect 5(10) to be 5(8)")(assert(toOctal(5) === 5))
  test("Expect 8(10) to be 10(8)")(assert(toOctal(8) === 10))
  test("Expect 15(10) to be 17(8)")(assert(toOctal(15) === 17))
  test("Expect 16(10) to be 20(8)")(assert(toOctal(16) === 20))
  test("Expect 33(10) to be 41(8)")(assert(toOctal(33) === 41))
}

class ConvertTest extends FunSuite {
  test("Expect 12(10) to be 1100(2)")(assert(convert(12, 2) === 1100))
  test("Expect 0(10) to be 0(2)")(assert(convert(0, 2) === 0))
  test("Expect 0(10) to be 0(1)")(assert(convert(0, 1) === 0))
  test("Expect 0(10) to be 0(3)")(assert(convert(0, 3) === 0))
  test("Expect 1(10) to be 1(2)")(assert(convert(1, 2) === 1))
  test("Expect 2(10) to be 10(2)")(assert(convert(2, 2) === 10))
  test("Expect 3(10) to be 11(2)")(assert(convert(3, 2) === 11))
}

class AddTest extends FunSuite {
  test("Expect 1 + 1/2 to be 3/2")(assert(_root_.Number.add(1, createRational(1, 2)) === createRational(3, 2)))
  test("Expect 3/2 + 1/2 to be 2")(assert(_root_.Number.add(createRational(3, 2), createRational(1, 2)) === 2))
  test("Expect -3/2 + 1/2 to be -1")(assert(_root_.Number.add(createRational(-3, 2), createRational(1, 2)) === -1))
  test("Expect 1/3 + 1/2 to be 5/6")(assert(_root_.Number.add(createRational(1, 3), createRational(1, 2)) === createRational(5, 6)))
  test("Expect 1/3 + 1/2 + 5i to be 5/6 + 5i")(assert(_root_.Number.add(createRational(1, 3), new ComplexRational(createRational(1, 2), createRational(5, 1))) === new ComplexRational(createRational(5, 6), createRational(5, 1))))
  test("Expect 1/3 + 1/2 + 0i to be 5/6")(assert(_root_.Number.add(createRational(1, 3), new ComplexRational(createRational(1, 2), createRational(0, 1))) === createRational(5, 6)))
}

class MultTest extends FunSuite {
  test("Expect 1 * 1/2 to be 1/2")(assert(_root_.Number.mult(1, createRational(1, 2)) === createRational(1, 2)))
  test("Expect 2/1 * 1/2 to be 1")(assert(_root_.Number.mult(createRational(2, 1), createRational(1, 2)) === 1))
  test("Expect -3/2 * 1/2 to be -3/4")(assert(_root_.Number.mult(createRational(-3, 2), createRational(1, 2)) === createRational(-3,4)))
  test("Expect 1/3 * 0 to be 0")(assert(_root_.Number.mult(createRational(1, 3), 0) === 0))
  test("Expect 3 + 5i * 4 + 11i to be -43 + 53i")(assert(_root_.Number.mult(new ComplexRational(createRational(3, 1), createRational(5, 1)), new ComplexRational(createRational(4, 1), createRational(11, 1))) === new ComplexRational(createRational(-43, 1), createRational(53, 1))))
  test("Expect 0 * 1/2 + 0i to be 0")(assert(_root_.Number.mult(0, new ComplexRational(createRational(1, 2), createRational(0, 1))) === 0))
}