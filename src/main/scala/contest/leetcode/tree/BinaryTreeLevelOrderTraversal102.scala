package contest.leetcode.tree

import scala.language.implicitConversions

/**
 * @author Dmitry Openkov
 */
object BinaryTreeLevelOrderTraversal102 {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def levelOrder(root: TreeNode): List[List[Int]] = {

    def go(level: List[TreeNode]): List[List[Int]] =
      if (level.isEmpty) List.empty
      else level.map(_.value) :: go(level.flatMap(node => Option(node.left) ++ Option(node.right)))

    go(Option(root).toList)
  }
}
