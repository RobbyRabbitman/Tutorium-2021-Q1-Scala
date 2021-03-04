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

  def copy(x: List): List = x match {
    case x: EmptyList => x
    case x: NonEmptyList => NonEmptyList(x.value, x.rest)
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

  case class ListPair(firstList: List, secondList: List)

  def quickSort(l: List): List = l match {
    case l: EmptyList => l
    case l: NonEmptyList => {
      val partitionedInput: ListPair = partition(l);
      append(quickSort(partitionedInput.firstList), NonEmptyList(l.value, quickSort(partitionedInput.secondList)))
    }
  }

  private def partition(l: List): ListPair = l match {
    case l: EmptyList => ListPair(EmptyList(), EmptyList())
    case l: NonEmptyList => partitionHelper(l.value, l.rest, EmptyList(), EmptyList())
  }

  private def partitionHelper(pivot: Any, current: List, left: List, right: List): ListPair = current match {
    case current: EmptyList => ListPair(left, right)
    case current: NonEmptyList =>
      if (compare(current.value, pivot))
        partitionHelper(pivot, current.rest, NonEmptyList(current.value, left), right)
      else
        partitionHelper(pivot, current.rest, left, NonEmptyList(current.value, right))
  }

  def splitAt(l: List, pos: Int): ListPair = {
    if (pos >= _root_.List.length(l)) ListPair(l, EmptyList())
    else splitAtHelper(l, pos)
  }

  private def splitAtHelper(l: List, pos: Int): ListPair = {
    if (pos == 0) ListPair(EmptyList(), l)
    else l match {
      case l: EmptyList => ListPair(EmptyList(), EmptyList())
      case l: NonEmptyList => {
        val nextPair: ListPair = splitAtHelper(l.rest, pos - 1)
        ListPair(NonEmptyList(l.value, nextPair.firstList), nextPair.secondList)
      }
    }
  }


  def merge(sorted1: List, sorted2: List): List = (sorted1, sorted2) match {
    case (s1: EmptyList, s2: List) => s2
    case (s1: List, s2: EmptyList) => s1
    case (s1: NonEmptyList, s2: NonEmptyList) =>
      if (compare(s1.value, s2.value)) NonEmptyList(s1.value, merge(s1.rest, s2))
      else NonEmptyList(s2.value, merge(s1, s2.rest))
  }

  def mergeSort(list: List): List = list match {
    case list: EmptyList => list
    case list: NonEmptyList => list.rest match {
      case r: EmptyList => list
      case r: NonEmptyList => {
        val split: ListPair = splitAt(list, length(list) / 2)
        merge(mergeSort(split.firstList), mergeSort(split.secondList))
      }
    }
  }
}
