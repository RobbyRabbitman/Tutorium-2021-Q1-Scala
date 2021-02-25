abstract sealed class CharList

case class EmptyCharList() extends CharList

case class NonEmptyCharList(value: Char, rest: CharList) extends CharList

package object CharList {
  def length(list: CharList): Int = list match {
    case x: EmptyCharList => 0
    case x: NonEmptyCharList => 1 + length(x.rest)
  }

  def charListToString(list: CharList): String = list match {
    case x: EmptyCharList => ""
    case x: NonEmptyCharList => x.value.toString + charListToString(x.rest)
  }

  def StringToCharList(word: String): CharList =
    if (word.isEmpty) EmptyCharList()
    else NonEmptyCharList(word.head, StringToCharList(word.tail))

}