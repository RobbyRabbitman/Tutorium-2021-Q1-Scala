case class Rational(enumerator: Int, denominator: Int)

package object Rational {
  /**
   *
   * @param enumerator
   * @param denominator
   * @return creates a rational, throws an exception if denominator is 0
   */
  def createRational(enumerator: Int, denominator: Int): Rational =
    if (denominator == 0)
      throw new IllegalArgumentException("Denominator must not be 0!")
    else
     new Rational(enumerator, denominator)
}
