import org.scalatest.FunSuite

class TestDemo extends FunSuite {

  test("1 + 1 = 2")( () => {
    assert(1+1 === 2)
  })

  /**
   * 1d: Nicht den zu erwartenden Wert eines Tests ändern, sondern die Funktion, die getestet wird.
   * (Warum? Man hat sich vorher Gedanken gemacht, was richtig und falsch ist und sollte dementsprechend nicht
   * die zu erwartenden Werte ändern, nur damit die Testfälle "korrekt" werden)
   */
  test("the answer to all"){
    assert(6 * 7 === 42)
  }
}