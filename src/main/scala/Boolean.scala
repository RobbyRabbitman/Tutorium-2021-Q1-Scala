
package object Boolean {

  def trueValue(): Boolean = {
    println("return true!")
    true
  }

  def falseValue(): Boolean = {
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
  def xor_lazy(x: Boolean, y: Boolean): Boolean = x && !y || !x && y

  def xor(x: Boolean, y: Boolean): Boolean = x != y

  def equal(x: Boolean, y: Boolean): Boolean = x == y

  def implies(x: Boolean, y: Boolean): Boolean = !x || y

  def xor_withIfs(x: Boolean, y: Boolean): Boolean = if (x) {
    if (y) false else true
  } else if (y) true else false
}
