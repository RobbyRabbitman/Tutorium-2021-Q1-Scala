
package object Boolean {
  /** Anmerkung: De-morgansche Gesetze
   *
   * @param x [[Boolean]]
   * @param y [[Boolean]]
   * @return !(x && y)
   */
  def nand(x: Boolean, y: Boolean): Boolean = !(x && y) // !x || !y
}
