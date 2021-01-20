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

  /**
   *
   * @param n [[BigInt]] >= 0
   * @return !n
   */
  def factorial(n: BigInt): BigInt = {
    if (n < 0) throw new ArithmeticException("The input value must not be negativ! Provided " + n)
    if (n == 0) 1 else factorial(n - 1) * n
  }

  /**
   *
   * @param x [[Int]]
   * @param y [[Int]] >= 0
   * @return x^y
   */
  def power(x: Int, y: Int): Int = {
    if (y < 0) throw new IllegalArgumentException("Exponent must not be negative! Provided " + y)
    if (y == 0) 1 else power(x, y - 1) * x
  }

  /**
   *
   * @param n [[Int]] >= 0
   * @return the sum of the squares of the digits of n
   */
  def sumOfSquaresOfDigits(n: Int): Int = {
    if (n < 0) throw new IllegalArgumentException("Exponent must be a natural number! Provided " + n)
    if (n < 10) power(n, 2) else sumOfSquaresOfDigits(n / 10) + power(n % 10, 2)
  }

  /**
   *
   * @param a
   * @param b
   * @return (d,s,t) such as gcd(a,b) = d = s * a + t * b
   */
  def extendedEuclidAlgorithm(a: Int, b: Int): (Int, Int, Int) = {
    // https://de.wikipedia.org/wiki/Erweiterter_euklidischer_Algorithmus#Rekursive_Variante_2
    if (b == 0) return (a, 1, 0)
    val (d, s, t) = extendedEuclidAlgorithm(b, a % b)
    (d, t, s - (a / b) * t)
  }

  /**
   *
   * @param x [[Int]]
   * @param m [[Int]] >= 0
   * @return x such as x is the smallest positive number so that: ax % m = 1 or None if it doesn't exists
   */
  def inverseModule(x: Int, m: Int): Option[Int] = {
    if(m < 1) throw new ArithmeticException("Module must be positive!")
    val (d, s, _) = extendedEuclidAlgorithm(x, m)
    if (d == 1) Option(if (s < 0) s + m else s) else Option.empty
  }
}
