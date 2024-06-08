package contest.leetcode.tree

class Trie208:

  private class Node(
    var isWord: Boolean = false,
    val children: Array[Node] = Array.ofDim('z' - 'a' + 1)
  ):
    def getChildOrCreateOne(char: Char): Node =
      getChild(char) match
        case None =>
          val node = Node()
          children(char - 'a') = node
          node
        case Some(node) => node

    def getChild(char: Char): Option[Node] = Option(children(char - 'a'))

  private val root: Node = Node()

  def insert(word: String): Unit =
    word.foldLeft(root) { case (parent, char) =>
      parent.getChildOrCreateOne(char)
    }.isWord = true

  def search(word: String): Boolean =
    val nodes = takeNodes(word)
    nodes.length == word.length && nodes.last.isWord

  def startsWith(prefix: String): Boolean =
    val nodes = takeNodes(prefix)
    nodes.length == prefix.length

  private def takeNodes(word: String): IndexedSeq[Node] =
    IndexedSeq.unfold((root, word)) { case (node, word) =>
      val nodeOpt: Option[Node] = word.headOption.fold(None)(node.getChild)
      nodeOpt.map { node =>
        (node, (node, word.tail))
      }
    }

end Trie208