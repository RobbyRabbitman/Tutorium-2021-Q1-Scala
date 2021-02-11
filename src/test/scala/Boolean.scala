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

/**
 *  30
 */
class LazyDemo extends FunSuite {



  /** Lazy Behavior
   * https://stackoverflow.com/questions/25067702/scala-booleans-vs-vs
   */

  test("|")({
    println()
    println(s"true | true = ${trueValue | trueValue}\n")
    println(s"true | false = ${trueValue | falseValue}\n")
    println(s"false | true = ${falseValue | trueValue}\n")
    println(s"false | false = ${falseValue | falseValue}\n")
  })

  test("||")({
    println()
    println(s"true || true = ${trueValue || trueValue}\n")
    println(s"true || false = ${trueValue || falseValue}\n")
    println(s"false || true = ${falseValue || trueValue}\n")
    println(s"false || false = ${falseValue || falseValue}\n")
  })

  test("&")({
    println()
    println(s"true & true = ${trueValue & trueValue}\n")
    println(s"true & false = ${trueValue & falseValue}\n")
    println(s"false & true = ${falseValue & trueValue}\n")
    println(s"false & false = ${falseValue & falseValue}\n")
  })

  test("&&")({
    println()
    println(s"true && true = ${trueValue && trueValue}\n")
    println(s"true && false = ${trueValue && falseValue}\n")
    println(s"false && true = ${falseValue && trueValue}\n")
    println(s"false && false = ${falseValue && falseValue}\n")
  })
}