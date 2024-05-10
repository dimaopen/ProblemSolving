package contest.leetcode.tree

import contest.leetcode.tree.BinaryTreeLevelOrderTraversal102.TreeNode
import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

/**
 * @author Dmitry Openkov
 */
class BinaryTreeLevelOrderTraversal102Test extends AnyWordSpec with ScalaCheckPropertyChecks {

  "BinaryTreeLevelOrderTraversal" should {
    "return levels" in {
      BinaryTreeLevelOrderTraversal102.levelOrder(new TreeNode(1,
        _left = new TreeNode(2, _left = new TreeNode(4)),
        _right = new TreeNode(3, _right = new TreeNode(5)))) shouldBe List(List(1), List(2, 3), List(4, 5))
      BinaryTreeLevelOrderTraversal102.levelOrder(new TreeNode(1)) shouldBe List(List(1))
      BinaryTreeLevelOrderTraversal102.levelOrder(null) shouldBe List()
    }
  }
}
