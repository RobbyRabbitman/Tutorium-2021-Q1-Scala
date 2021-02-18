case class Rational(enumerator: Int, denominator: Int)

import _root_.String._
import _root_.Number._

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
      toCanonical(new Rational(enumerator, denominator))

  def toDivString(r: Rational): String = ToString(r.enumerator) + "/" + ToString(r.denominator)

  def toCanonical(r: Rational): Rational = {
    val gcd: Int = Number.gcd(r.enumerator, r.denominator)
    val sign: Int = if (r.denominator < 0) -1 else 1
    new Rational(r.enumerator / gcd * sign, abs(r.denominator / gcd))
  }
}
