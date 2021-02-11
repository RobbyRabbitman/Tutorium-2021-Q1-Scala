
package object Boolean {

  def trueValue():Boolean = {
    println("return true!")
    true
  }

  def falseValue():Boolean = {
    println("return false!")
    false
  }

  /** Anmerkung: De-morgansche Gesetze
   *
   * @param x [[Boolean]]
   * @param y [[Boolean]]
   * @return !(x && y)
   */
  def nand(x: Boolean, y: Boolean): Boolean = !(x && y) // !x || !y

  /**
   *
   * @param x [[Boolean]]
   * @param y [[Boolean]]
   * @return x && !y || !x && y
   */
  def xor(x: Boolean, y: Boolean): Boolean = x && !y || !x && y
}
