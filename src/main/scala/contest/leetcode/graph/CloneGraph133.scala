package contest.leetcode.graph

/**
 * @author Dmitry Openkov
 */
object CloneGraph133 {
  class Node(var _value: Int) {
    var value: Int = _value
    var neighbors: List[Node] = List()
  }

  def cloneGraph(graph: Node): Node = {
    def dfs(node: Node, visited: Map[Int, Node]): (Map[Int, Node], Node) = {
      visited.get(node.value) match {
        case Some(clone) => (visited, clone)
        case None =>
          val clone = new Node(node.value)
          val (cloneNeighbors, newVisited) = node.neighbors
            .foldLeft(List.empty[Node] -> visited.updated(node.value, clone)) {
              case ((acc, visited), node) =>
                val (clone, newNode) = dfs(node, visited)
                (newNode :: acc, clone)
            }
          clone.neighbors = cloneNeighbors
          newVisited -> clone
      }
    }

    if (graph == null)
      null
    else {
      val (_, clonedGraph) = dfs(graph, Map.empty)
      clonedGraph
    }
  }
}