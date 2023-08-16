package contest.leetcode

import scala.collection.mutable.ArrayBuffer

/**
 * @author Dmitry Openkov
 */
object LongestValidParentheses32 {
  sealed trait Node {
    def validSeqLength: Int
  }

  class Closed(val validSeqLength: Int) extends Node

  class Unclosed(
    val parent: Unclosed,
    val children: ArrayBuffer[Node] = ArrayBuffer.empty,
  ) extends Node {
    def validSeqLength: Int = {
      val split = children.foldLeft(List(0)) {
        case (head :: tail, child: Closed) => head + child.validSeqLength :: tail
        case (list, child) => child.validSeqLength :: list
      }
      split.max
    }

    def close(): Closed = new Closed(validSeqLength + 2)

    def isGlobalVirtualNode: Boolean = parent == null
  }

  def longestValidParentheses(s: String): Int = {
    val globalNode = new Unclosed(null)
    s.foldLeft(globalNode) {
      case (curNode, '(') =>
        val newChild = new Unclosed(curNode)
        curNode.children.addOne(newChild)
        newChild
      case (curNode, ')') =>
        if (curNode.isGlobalVirtualNode) {
          curNode.children.addOne(new Unclosed(curNode))
          curNode
        } else {
          val closed = curNode.close()
          val parent = curNode.parent
          parent.children.remove(parent.children.length - 1)
          parent.children.addOne(closed)
          parent
        }
    }
    globalNode.validSeqLength
  }

  def main(args: Array[String]): Unit = {
    println("( = " + longestValidParentheses("(")) // 0
    println(") = " + longestValidParentheses(")")) // 0
    println("empty = " + longestValidParentheses("")) // 0
    println("(()(((() = " + longestValidParentheses("(()(((()")) // 2
    println("() = " + longestValidParentheses("()")) // 2
    println("()( = " + longestValidParentheses("()(")) // 2
    println("())) = " + longestValidParentheses("()))")) // 2
    println("()(() = " + longestValidParentheses("()(()")) // 2
    println("()(()() = " + longestValidParentheses("()(()()")) // 4
    println("(()())() = " + longestValidParentheses("(()())()")) // 8
    println("((())))) = " + longestValidParentheses("((()))))")) // 6
    println(")))())((())))) = " + longestValidParentheses(")))())((()))))")) // 6
    println(")))()((()))))()()()()()() = " + longestValidParentheses(")))()((()))))()()()()()()")) // 12
  }
}
