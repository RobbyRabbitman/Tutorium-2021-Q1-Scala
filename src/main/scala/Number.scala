package object Number {
  /**
   * Answer to everything
   */
  val ANSWER_TO_EVERYTHING: Int = 42

  /**
   *
   * @param x any [[Int]]
   * @return true, if x > [[Number.ANSWER_TO_EVERYTHING]], else false
   */
  def isGreaterThanAnswerToEverything(x: Int): Boolean = x > ANSWER_TO_EVERYTHING

  /** Fragen:
   * Vorteil Double gegenüber Int? Dezimalzahlen möglich.
   * Was passiert bei x * x > [[Double.MaxValue]]? Stackoverflow sagt [[Double.MaxValue]] + 1 = [[Double.PositiveInfinity]], also kein overflow
   *
   * @param x any [[Double]]
   * @return square of x
   */
  def square(x: Double): Double = x * x;

  /** Fragen:
   * Was passiert bei max(Int.MaxValue + 1, Int.MaxValue)? Bei Int gibt es einen overflow.
   *
   * @param x [[Int]]
   * @param y [[Int]]
   * @return y if x < y, else x
   */
  def max(x: Int, y: Int): Int = if (x < y) y else x

  /**
   *
   * @param x [[Int]]
   * @return |x|
   */
  def abs(x: Int): Int = if (x < 0) -x else x // math.abs(x)

  /** Fragen: Warum kann es sinnvoll sein seine eigenen mathematischen Funktionen zu bauen?
   * Es kann unterschiedliche Definitionen und Konventionen geben.
   * Zum Beispiel beim Modulo, was aber hier nicht der Fall ist.
   *
   * @param n [[Int]]
   * @param m [[Int]]
   * @return n%m
   */
  def %(n: Int, m: Int): Int = {
    val abs_n: Int = abs(n)
    val abs_m: Int = abs(m)
    var r: Int = abs_n
    if (abs_m == 0) throw new ArithmeticException("The divider in modulo must not be 0")
    while (r >= abs_m) r -= abs_m
    if (n < 0) -r else r
  }
}
