abstract sealed class List

case class EmptyList() extends List

case class NonEmptyList(value: Any, rest: List) extends List

package object List {

}
