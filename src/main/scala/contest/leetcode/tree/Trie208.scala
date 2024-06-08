package contest.leetcode.tree

import scala.collection.mutable

class Trie208:

  private class Node(val c: Char, var present: Boolean, val children: mutable.Map[Char, Node]) extends Ordered[Node]:
    def compare(that: Node): Int = this.c - that.c

  private val root: Node = Node(Char.MinValue, true, mutable.Map.empty)

  def insert(word: String): Unit =
    val node = word.foldLeft(root) { case (parent, char) =>
      val node = parent.children.getOrElseUpdate(char, Node(char, present = false, mutable.Map.empty))
      node
    }
    node.present = true

  def search(word: String): Boolean =
    val nodes = takeNodes(word)
    nodes.length == word.length && nodes.last.present

  def startsWith(prefix: String): Boolean =
    val nodes = takeNodes(prefix)
    nodes.length == prefix.length

  private def takeNodes(word: String) =
    IndexedSeq.unfold((root.children, word)) { case (nodes, word) =>
      val nodeOpt = word.headOption.fold(None)(nodes.get)
      nodeOpt.map { node =>
        (node, (node.children, word.tail))
      }
    }

end Trie208