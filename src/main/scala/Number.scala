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
   * @param n [[BigInt]] >= 0
   * @return !n
   */
  def _factorial(n: BigInt): BigInt = {
    if (n < 0) throw new ArithmeticException("The input value must not be negativ! Provided " + n)
    var result: BigInt = 1;
    var current: BigInt = n;
    while (current > 1) {
      result *= current
      current -= 1
    }
    result
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
   * @param x [[Int]]
   * @param y [[Int]] >= 0
   * @return x^y
   */
  def _power(x: Int, y: Int): Int = {
    if (y < 0) throw new IllegalArgumentException("Exponent must not be negative! Provided " + y)
    var result: Int = 1;
    var counter: Int = y;
    while (counter > 0) {
      result *= x
      counter -= 1
    }
    result
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
    if (m < 1) throw new ArithmeticException("Module must be positive!")
    val (d, s, _) = extendedEuclidAlgorithm(x, m)
    if (d == 1) Option(if (s < 0) s + m else s) else Option.empty
  }

  /** Frage: Performant? Nein, da eigentlich schon bereits kalkulierte Ergebnisse immer wieder neu berechnet werden.
   * f(n)=f(n-1)+f(n-2) = f(n-2)+f(n-3)+f(n-3)+f(n-4) = ... = 1 + 1 + 1 + 1 ...
   * besser: f(n) = f(n-1) + f(n-2) = x + y, x und y bereits berechnet
   *
   * @param n n >= 0
   * @return f(n)=f(n-1)+f(n-2), f(0)=0, f(1)=1
   */
  def fib(n: Int): Int = {
    if (n < 0) throw new IllegalArgumentException("n must not be negative!")
    else if (n == 0 || n == 1) n else fib(n - 1) + fib(n - 2)
  }

  /**
   *
   * @param n n >= 2
   * @return true if n is a prime number, else false
   */
  def isPrime(n: Int): Boolean = {
    if (n < 2) throw new IllegalArgumentException("n must be >= 2!")
    if (n == 2 || n == 3) return true
    if (n % 2 == 0) return false
    var current = 3
    while (current < n) {
      if (n % current == 0) return false
      current += 2
    }
    true
  }

  /**
   *
   * @param a
   * @param b
   * @return greatest common divider
   */
  def gcd(a: Int, b: Int): Int = {
    if (b == 0) abs(a) else gcd(b, a % b)
  }

  /**
   *
   * @param a
   * @param b
   * @return least common multiple using |a| and |b|
   */
  def lcm(a: Int, b: Int): Int = if (a == 0 || b == 0) 0 else (abs(a) / gcd(a, b)) * abs(b)

  /**
   *
   * @param n >= 0
   * @return n' with mirrored digits, leading zeros are removed
   */
  def mirror(n: Int): Int =
    if (n < 0) throw new IllegalArgumentException("n must be a natural number!")
    else mirrorHelper(n, 0)

  private def mirrorHelper(in: Int, out: Int): Int = if (in == 0) out else mirrorHelper(in / 10, out * 10 + in % 10)

  /**
   *
   * @param n >= 0
   * @return n' with mirrored digits, leading zeros are removed
   */
  def _mirror(n: Int): Int = {
    if (n < 0) throw new IllegalArgumentException("n must be a natural number!")
    else n.toString().reverse.toInt // "".toInt == 0
  }

  /**
   *
   * @param n to base 10
   * @param base
   * @return
   */
  def convert(n: Int, base: Int): Int = if (base <= 0 || base >= 10) throw new IllegalArgumentException()
  else if (n == 0) 0 else (n % base) + convert(n / base, base) * 10

  def toOctal(n:Int):Int = convert(n,8)
}
