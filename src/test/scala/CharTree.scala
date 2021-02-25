import CharTree.charListToCharTree
import org.scalatest.FunSuite

class charListToCharTreeTest extends FunSuite {
  test("Expect [1,2,a] to be Tree1,2,a ")(assert(charListToCharTree(NonEmptyCharList('a', NonEmptyCharList('1', NonEmptyCharList('2', EmptyCharList())))) ===
    NonEmptyCharTree(NonEmptyCharTree(EmptyCharTree(), '1', EmptyCharTree()), '2', NonEmptyCharTree(EmptyCharTree(), 'a', EmptyCharTree()))))
}