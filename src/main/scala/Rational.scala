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
      throw new ArithmeticException("Denominator must not be 0!")
    else
      toCanonical(new Rational(enumerator, denominator))

  def toDivString(r: Rational): String = ToString(r.enumerator) + "/" + ToString(r.denominator)

  def toCanonical(r: Rational): Rational = {
    val gcd: Int = Number.gcd(r.enumerator, r.denominator)
    val sign: Int = if (r.denominator < 0) -1 else 1
    new Rational(r.enumerator / gcd * sign, abs(r.denominator / gcd))
  }

  def sameValue(r1: Rational, r2: Rational): Boolean =
    r1.denominator == r2.denominator && r1.enumerator == r2.enumerator

  def less(r1: Rational, r2: Rational): Boolean =
    r1.enumerator * r2.denominator < r2.enumerator * r1.denominator

  def add(r1: Rational, r2: Rational): Rational =
    createRational(r2.denominator * r1.enumerator + r1.denominator * r2.enumerator, r1.denominator * r2.denominator)

  def sub(r1: Rational, r2: Rational): Rational =
    createRational(r2.denominator * r1.enumerator - r1.denominator * r2.enumerator, r1.denominator * r2.denominator)

  def mult(r1: Rational, r2: Rational): Rational =
    createRational(r1.enumerator * r2.enumerator, r1.denominator * r2.denominator)

  def divide(r1: Rational, r2: Rational): Rational =
    createRational(r1.enumerator * r2.denominator, r1.denominator * r2.enumerator)
}
