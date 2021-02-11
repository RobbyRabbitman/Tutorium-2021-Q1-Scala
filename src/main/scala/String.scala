package object String {
  def concat(x: String, y: String): String = x.concat(y)

  def head(of: String): String = if (of.isEmpty) "" else of.head.toString

  def tail(of: String): String = if (of.isEmpty) "" else of.tail

  /**
   *
   * @param word
   * @return word reversed. abcd -> dcba
   */
  def reverse(word: String): String = if (word.length == 0) "" else concat(reverse(tail(word)), head(word))

  /**
   *
   * @param word
   * @param times
   * @return word n times concatenated, if n <= 0 an empty string will be returned.
   */
  def repeat(word: String, times: Int): String = if (times <= 0) "" else concat(word, repeat(word, times - 1))

  /**
   *
   * @param word
   * @param searchTerm
   * @return how often word contains searchTearm. Returns 0 if searchTearm.length == 0
   *
   *         (HansHugo,Hans) -> 1, (aaabbb, a) -> 3
   */
  def containsHowOften(word: String, searchTerm: String): Int = {
    if (word.length < searchTerm.length || searchTerm.isEmpty) return 0
    val contains: Int = if (word.substring(0, searchTerm.length) == searchTerm) 1 else 0
    containsHowOften(tail(word), searchTerm) + contains
  }

  /**
   *
   * @param word
   * @param c
   * @return swaps the word at the c or not if word does not contain c
   */
  def swapAt(word: String, c: Char): String = swapAtHelper("", word, c.toString)

  private def swapAtHelper(left: String, right: String, c: String): String = {
    if (right.isEmpty) left
    else if (head(reverse(left)) == c) concat(concat(right, c), reverse(tail(reverse(left))))
    else swapAtHelper(concat(left, head(right)), tail(right), c)
  }

  def shift(word: String): String = shiftHelper(word, "")

  private def shiftHelper(in: String, out: String): String =
    if (in.length <= 1) concat(in, out) else shiftHelper(tail(in), concat(out, head(in)))

  def shiftBack(word: String): String = concat(tail(word), head(word))

  /**
   *
   * @param word
   * @param other
   * @return if word < other by character comparison (ASCII value)
   */
  def less(word: String, other: String): Boolean = !(word == other) && lessHelper(word, other)

  private def lessHelper(word: String, other: String): Boolean =
    try {
      word.isEmpty || word.head < other.head && lessHelper(word.tail, other.tail)
    } catch {
      case _: Exception => false
    }
}
