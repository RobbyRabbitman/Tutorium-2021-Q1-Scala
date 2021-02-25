import scala.annotation.tailrec
import scala.util.Random

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

  def ToString(x: List): String = "[" + ToStringHelper(x).dropRight(1) + "]"

  private def ToStringHelper(x: List): String = x match {
    case x: EmptyList => ""
    case x: NonEmptyList => x.value.toString + "," + ToStringHelper(x.rest)
  }

  def flatten(x: List): List = x match {
    case x: EmptyList => x
    case x: NonEmptyList => x.value match {
      case value: List => append(flatten(value), flatten(x.rest))
      case value: Any => NonEmptyList(value, flatten(x.rest))
    }
  }

  def createRandomIntList(n: Int = 50): List =
    if (n < 0) throw new IllegalArgumentException()
    else if (n == 0) EmptyList()
    else NonEmptyList(Random.nextInt(100), createRandomIntList(n - 1))


  def compare(x: Any, y: Any): Boolean = (x, y) match {
    case (x: Int, y: Int) => x < y
  }

  private def bubbleOneRun(list: List): List = list match {
    case list: EmptyList => list
    case list: NonEmptyList => list.rest match {
      case rest: EmptyList => list
      case rest: NonEmptyList =>
        if (compare(list.value, rest.value)) NonEmptyList(list.value, bubbleOneRun(rest))
        else NonEmptyList(rest.value, bubbleOneRun(NonEmptyList(list.value, rest.rest)))
    }
  }

  private def bubbleSortHelper(current: List, upTo: Int): List =
    if (upTo == 0) current
    else bubbleSortHelper(bubbleOneRun(current), upTo - 1)


  def bubbleSort(list: List): List = bubbleSortHelper(list, length(list))


}
