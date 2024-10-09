package contest.leetcode.tree

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null):
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right

  override def toString: String = s"TreeNode($value${Option(left).fold("")(" L:" + _.value)}${Option(right).fold("")(" R:" + _.value)})"
end TreeNode

object TreeNode:

  def createTree(array: Integer*): TreeNode =
    def go(node: TreeNode, nodeNum: Int): Unit =
      val leftNum = nodeNum * 2 + 1
      val leftValue = array.lift(leftNum).orNull
      if leftValue != null then
        node.left = TreeNode(leftValue)
        go(node.left, leftNum)
      val rightNum = nodeNum * 2 + 2
      val rightValue = array.lift(rightNum).orNull
      if rightValue != null then
        node.right = TreeNode(rightValue)
        go(node.right, rightNum)

    val root = TreeNode(array.head)
    go(root, 0)
    root

end TreeNode