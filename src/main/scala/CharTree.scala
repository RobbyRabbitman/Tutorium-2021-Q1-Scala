import List.{compare, length}

abstract sealed class CharTree

case class EmptyCharTree() extends CharTree

case class NonEmptyCharTree(left: CharTree, root: Char, right: CharTree) extends CharTree

package object CharTree {

  case class ListPair(l1: CharList, l2: CharList)

  def charListToCharTree(cList: CharList): CharTree = charListToCharTreeHelper(bubbleSort(cList))

  def charListToCharTreeHelper(cList: CharList): CharTree = cList match {
    case cList: EmptyCharList => EmptyCharTree()
    case cList: NonEmptyCharList => {
      val listPair: ListPair = splitAt(cList, _root_.CharList.length(cList) / 2)
      val firstList: CharList = listPair.l1
      val secondList: CharList = listPair.l2
      secondList match {
        case secondList: EmptyCharList => throw new Exception("Fatal error!") //Because length(firstList) <= length(secondList)
        case secondList: NonEmptyCharList => NonEmptyCharTree(charListToCharTreeHelper(firstList), secondList.value, charListToCharTree(secondList.rest))
      }
    }
  }

  def splitAt(l: CharList, pos: Int): ListPair = {
    if (pos >= _root_.CharList.length(l)) ListPair(l, EmptyCharList())
    else splitAtHelper(l, pos)
  }

  private def splitAtHelper(l: CharList, pos: Int): ListPair = {
    if (pos == 0) ListPair(EmptyCharList(), l)
    else l match {
      case l: EmptyCharList => ListPair(EmptyCharList(), EmptyCharList())
      case l: NonEmptyCharList => {
        val nextPair: ListPair = splitAtHelper(l.rest, pos - 1)
        ListPair(NonEmptyCharList(l.value, nextPair.l1), nextPair.l2)
      }
    }
  }

  private def bubbleOneRun(list: CharList): CharList = list match {
    case list: EmptyCharList => list
    case list: NonEmptyCharList => list.rest match {
      case rest: EmptyCharList => list
      case rest: NonEmptyCharList =>
        if (list.value < rest.value) NonEmptyCharList(list.value, bubbleOneRun(rest))
        else NonEmptyCharList(rest.value, bubbleOneRun(NonEmptyCharList(list.value, rest.rest)))
    }
  }

  private def bubbleSortHelper(current: CharList, upTo: Int): CharList =
    if (upTo == 0) current
    else bubbleSortHelper(bubbleOneRun(current), upTo - 1)

  def bubbleSort(list: CharList): CharList = bubbleSortHelper(list, _root_.CharList.length(list))
}