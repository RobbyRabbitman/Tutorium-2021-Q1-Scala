import org.scalatest.FunSuite
import _root_.Boolean._

class NandTest extends FunSuite {
  test("Expect !(true && true) to be false")(assert(nand(true, true) === false))
  test("Expect !(true && false) to be true")(assert(nand(true, false) === true))
  test("Expect !(false && true) to be true")(assert(nand(false, true) === true))
  test("Expect !(false && false) to be true")(assert(nand(false, false) === true))
}

class XorLazyTest extends FunSuite {
  test("Expect xor_lazy(true,true) to be false")(assert(xor_lazy(true, true) === false))
  test("Expect xor_lazy(true,false) to be true")(assert(xor_lazy(true, false) === true))
  test("Expect xor_lazy(false,true) to be true")(assert(xor_lazy(false, true) === true))
  test("Expect xor_lazy(false,false) to be false")(assert(xor_lazy(false, false) === false))
}

class XorTest extends FunSuite {
  test("Expect xor(true,true) to be false")(assert(xor(true, true) === false))
  test("Expect xor(true,false) to be true")(assert(xor(true, false) === true))
  test("Expect xor(false,true) to be true")(assert(xor(false, true) === true))
  test("Expect xor(false,false) to be false")(assert(xor(false, false) === false))
}

class XorWithIfsTest extends FunSuite {
  test("Expect xor_withIfs(true,true) to be false")(assert(xor_withIfs(true, true) === false))
  test("Expect xor_withIfs(true,false) to be true")(assert(xor_withIfs(true, false) === true))
  test("Expect xor_withIfs(false,true) to be true")(assert(xor_withIfs(false, true) === true))
  test("Expect xor_withIfs(false,false) to be false")(assert(xor_withIfs(false, false) === false))
}

class EqualsTest extends FunSuite {
  test("Expect equal(true,true) to be true")(assert(equal(true, true) === true))
  test("Expect equal(true,false) to be false")(assert(equal(true, false) === false))
  test("Expect equal(false,true) to be false")(assert(equal(false, true) === false))
  test("Expect equal(false,false) to be true")(assert(equal(false, false) === true))
}

class ImpliesTest extends FunSuite {
  test("Expect implies(true,true) to be true")(assert(implies(true, true) === true))
  test("Expect implies(true,false) to be false")(assert(implies(true, false) === false))
  test("Expect implies(false,true) to be true")(assert(implies(false, true) === true))
  test("Expect implies(false,false) to be true")(assert(implies(false, false) === true))
}

/**
 *  30,31.32
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

  test("implies")({
    println()
    println(s"true implies true = ${implies(trueValue(),trueValue())}\n")
    println(s"true implies false = ${implies(trueValue(),falseValue())}\n")
    println(s"false implies true = ${implies(falseValue(),trueValue())}\n")
    println(s"false implies false = ${implies(falseValue(),falseValue())}\n")
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