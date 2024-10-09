package contest.leetcode.tree

/**
 * @author Dmitry Openkov
 */
object ValidateBinarySearchTree98:

  def isValidBST(root: TreeNode): Boolean =
    def increaseOrder(node: TreeNode, stack: List[TreeNode]): LazyList[Int] =
      if node != null then
        increaseOrder(node.left, node :: stack)
      else if stack.nonEmpty then
        val node :: newStack = stack: @unchecked
        node.value #:: increaseOrder(node.right, newStack)
      else
        LazyList.empty

    val inorder = increaseOrder(root, Nil)
    inorder.zip(inorder.tail).forall { case (x, y) => x < y }

  def isValidBSTMinMax(root: TreeNode): Boolean =
    def go(node: TreeNode): (Boolean, Int, Int) =
      (node.left, node.right) match
        case (null, null) =>
          (true, node.value, node.value)
        case (leftNode: TreeNode, null) if leftNode.value < node.value =>
          val (subTreeOk, min, max) = go(leftNode)
          (subTreeOk && max < node.value, min, node.value)
        case (null, rightNode: TreeNode) if rightNode.value > node.value =>
          val (subTreeOk, min, max) = go(rightNode)
          (subTreeOk && min > node.value, node.value, max)
        case (leftNode: TreeNode, rightNode: TreeNode) if leftNode.value < node.value && rightNode.value > node.value =>
          val (leftTreeOk, leftMin, leftMax) = go(leftNode)
          val (rightTreeOk, rightMin, rightMax) = go(rightNode)
          (leftTreeOk && leftMax < node.value && rightTreeOk && rightMin > node.value, leftMin, rightMax)
        case _ =>
          (false, node.value, node.value)

    val (ok, _, _) = go(root)
    ok

end ValidateBinarySearchTree98
