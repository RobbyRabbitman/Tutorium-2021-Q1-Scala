package object Number {
  /**
   * Answer to everything
   */
  val ANSWER_TO_EVERYTHING:Int = 42

  /**
   *
   * @param x any [[Int]]
   * @return true, if x > [[Number.ANSWER_TO_EVERYTHING]], else false
   */
  def isGreaterThanAnswerToEverything(x:Int): Boolean = x > ANSWER_TO_EVERYTHING
}
