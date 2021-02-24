abstract sealed class List

case class EmptyList() extends List

case class NonEmptyList(value: Any, rest: List) extends List

package object List {
  def length(list: List): Int = list match {
    case x: EmptyList => 0
    case x: NonEmptyList => 1 + length(x.rest)
  }

  def append(x: List, y: List): List = x match {
    case x: EmptyList => y
    case x: NonEmptyList => NonEmptyList(x.value, append(x.rest, y))
  }

  def reverse(x: List): List = x match {
    case x: EmptyList => x
    case x: NonEmptyList => append(reverse(x.rest), NonEmptyList(x.value, EmptyList()))
  }
}
