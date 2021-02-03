package object String {
  def concat(x: String, y: String): String = x.concat(y)

  def head(of: String): Char = of.head

  def tail(of: String): String = of.tail

  /**
   *
   * @param word
   * @return word reversed. abcd -> dcba
   */
  def reverse(word: String): String = if (word.length == 0) "" else concat(reverse(tail(word)), head(word).toString())
}
