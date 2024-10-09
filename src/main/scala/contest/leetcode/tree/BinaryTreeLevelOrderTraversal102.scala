package contest.leetcode.tree

import scala.language.implicitConversions

/**
 * @author Dmitry Openkov
 */
object BinaryTreeLevelOrderTraversal102 {

  def levelOrder(root: TreeNode): List[List[Int]] = {

    def go(level: List[TreeNode]): List[List[Int]] =
      if (level.isEmpty) List.empty
      else level.map(_.value) :: go(level.flatMap(node => Option(node.left) ++ Option(node.right)))

    go(Option(root).toList)
  }
}
