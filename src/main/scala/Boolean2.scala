sealed abstract class Boolean2

case class True() extends Boolean2

case class False() extends Boolean2

package object Boolean2 {
  def and(x: Boolean2, y: Boolean2): Boolean2 = (x, y) match {
    case (x: True, y: True) => True()
    case (x: True, y: False) => False()
    case (x: False, y: True) => False()
    case (x: False, y: False) => False()
    case _ => throw new Exception("Fehlende Implementierung für " + x + ", " + y)
  }

  def or(x: Boolean2, y: Boolean2): Boolean2 = (x, y) match {
    case (x: True, y: True) => True()
    case (x: True, y: False) => True()
    case (x: False, y: True) => True()
    case (x: False, y: False) => False()
    case _ => throw new Exception("Fehlende Implementierung für " + x + ", " + y)
  }

  def xor(x: Boolean2, y: Boolean2): Boolean2 = (x, y) match {
    case (x: True, y: True) => False()
    case (x: True, y: False) => True()
    case (x: False, y: True) => True()
    case (x: False, y: False) => False()
    case _ => throw new Exception("Fehlende Implementierung für " + x + ", " + y)
  }

  def implies(x: Boolean2, y: Boolean2): Boolean2 = (x, y) match {
    case (x: True, y: True) => True()
    case (x: True, y: False) => False()
    case (x: False, y: True) => True()
    case (x: False, y: False) => True()
    case _ => throw new Exception("Fehlende Implementierung für " + x + ", " + y)
  }

  def isEqual(x: Boolean2, y: Boolean2): Boolean2 = (x, y) match {
    case (x: True, y: True) => True()
    case (x: True, y: False) => False()
    case (x: False, y: True) => False()
    case (x: False, y: False) => True()
    case _ => throw new Exception("Fehlende Implementierung für " + x + ", " + y)
  }

  def nand(x: Boolean2, y: Boolean2): Boolean2 = (x, y) match {
    case (x: True, y: True) => False()
    case (x: True, y: False) => True()
    case (x: False, y: True) => True()
    case (x: False, y: False) => True()
    case _ => throw new Exception("Fehlende Implementierung für " + x + ", " + y)
  }
}