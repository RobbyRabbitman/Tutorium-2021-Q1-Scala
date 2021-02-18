case class RationalNumber(enumerator: Int, denominator: Int)

import _root_.String._
import _root_.Number._

package object RationalNumber {
  /**
   *
   * @param enumerator
   * @param denominator
   * @return creates a rational, throws an exception if denominator is 0
   */
  def createRational(enumerator: Int, denominator: Int): RationalNumber =
    if (denominator == 0)
      throw new ArithmeticException("Denominator must not be 0!")
    else
      toCanonical(new RationalNumber(enumerator, denominator))

  def toDivString(r: RationalNumber): String = ToString(r.enumerator) + "/" + ToString(r.denominator)

  def toCanonical(r: RationalNumber): RationalNumber = {
    val gcd: Int = Number.gcd(r.enumerator, r.denominator)
    val sign: Int = if (r.denominator < 0) -1 else 1
    new RationalNumber(r.enumerator / gcd * sign, abs(r.denominator / gcd))
  }

  def sameValue(r1: RationalNumber, r2: RationalNumber): Boolean =
    r1.denominator == r2.denominator && r1.enumerator == r2.enumerator

  def less(r1: RationalNumber, r2: RationalNumber): Boolean =
    r1.enumerator * r2.denominator < r2.enumerator * r1.denominator

  def add(r1: RationalNumber, r2: RationalNumber): RationalNumber =
    createRational(r2.denominator * r1.enumerator + r1.denominator * r2.enumerator, r1.denominator * r2.denominator)

  def sub(r1: RationalNumber, r2: RationalNumber): RationalNumber =
    createRational(r2.denominator * r1.enumerator - r1.denominator * r2.enumerator, r1.denominator * r2.denominator)

  def mult(r1: RationalNumber, r2: RationalNumber): RationalNumber =
    createRational(r1.enumerator * r2.enumerator, r1.denominator * r2.denominator)

  def divide(r1: RationalNumber, r2: RationalNumber): RationalNumber =
    createRational(r1.enumerator * r2.denominator, r1.denominator * r2.enumerator)
}
