abstract sealed class CharList

case class EmptyCharList() extends CharList

case class NonEmptyCharList(value: Char, rest: CharList) extends CharList