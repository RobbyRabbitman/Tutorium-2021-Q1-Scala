abstract sealed class CharList

case class EmptyCharList() extends CharList

case class NonEmptyCharList(value: Char, rest: CharList) extends CharList

package object CharList {
  def length(list: CharList): Int = list match {
    case EmptyCharList() => 0
    case x: NonEmptyCharList => 1 + length(x.rest)
  }
}