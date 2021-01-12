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

  /** Fragen:
   * Vorteil Double gegenüber Int? Dezimalzahlen möglich.
   * Was passiert bei x * x > [[Double.MaxValue]]? Stackoverflow sagt [[Double.MaxValue]] + 1 = [[Double.PositiveInfinity]] und kein overflow
   *
   * @param x any [[Double]]
   * @return square of x
   */
  def square(x:Double):Double = x * x;
}
