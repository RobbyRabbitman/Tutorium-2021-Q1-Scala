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

  /**
   *
   * @param word
   * @param searchTerm
   * @return how often word contains searchTearm. Returns 0 if searchTearm.length == 0
   *
   * (HansHugo,Hans) -> 1, (aaabbb, a) -> 3
   */
  def containsHowOften(word: String, searchTerm: String): Int = {
    if (word.length < searchTerm.length || searchTerm.isEmpty) return 0
    val contains: Int = if (word.substring(0, searchTerm.length) == searchTerm) 1 else 0
    containsHowOften(tail(word), searchTerm) + contains
  }


}
