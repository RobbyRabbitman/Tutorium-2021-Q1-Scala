import _root_.RationalNumber._

case class ComplexRational(r: RationalNumber, i: RationalNumber)


package object ComplexRational {
  def ToString(c: ComplexRational): String = toDivString(c.r) + " + " + toDivString(c.i) + "i"


  def sameValue(c1: ComplexRational, c2: ComplexRational): Boolean = _root_.RationalNumber.sameValue(c1.r, c2.r) && _root_.RationalNumber.sameValue(c2.i, c2.i)

  def add(c1: ComplexRational, c2: ComplexRational) = new ComplexRational(_root_.RationalNumber.add(c1.r, c2.r), _root_.RationalNumber.add(c1.i, c2.i))

  def sub(c1: ComplexRational, c2: ComplexRational) = new ComplexRational(_root_.RationalNumber.sub(c1.r, c2.r), _root_.RationalNumber.sub(c1.i, c2.i))

  def mult(c1: ComplexRational, c2: ComplexRational) =
    new ComplexRational(_root_.RationalNumber.sub(_root_.RationalNumber.mult(c1.r, c2.r), _root_.RationalNumber.mult(c1.i, c2.i)), _root_.RationalNumber.add(_root_.RationalNumber.mult(c1.r, c2.i), _root_.RationalNumber.mult(c2.r, c1.i)))

  def div(c1: ComplexRational, c2: ComplexRational) = if (c2.r.enumerator == 0) new ComplexRational(
    _root_.RationalNumber.divide(_root_.RationalNumber.add(_root_.RationalNumber.mult(c1.r, c2.r), _root_.RationalNumber.mult(c1.i, c2.i)), _root_.RationalNumber.add(_root_.RationalNumber.mult(c2.r, c2.r), _root_.RationalNumber.mult(c2.i, c2.i))),
    _root_.RationalNumber.divide(_root_.RationalNumber.sub(_root_.RationalNumber.mult(c1.i, c2.r), _root_.RationalNumber.mult(c1.r, c2.i)), _root_.RationalNumber.add(_root_.RationalNumber.mult(c2.r, c2.r), _root_.RationalNumber.mult(c2.i, c2.i))))

}