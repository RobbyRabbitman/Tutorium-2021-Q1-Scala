import org.scalatest.FunSuite

class TestDemo extends FunSuite {

  test("1 + 1 = 2")( () => {
    assert(1+1 === 2)
  })

  // setup 1d
  test("fail"){
    assert(6 * 9 === 42)
  }
}