package contest.leetcode.tree

import contest.leetcode.tree.TreeNode
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

/**
 * @author Dmitry Openkov
 */
class ValidateBinarySearchTree98Test extends AnyWordSpec with ScalaCheckPropertyChecks {

  "ValidateBinarySearchTree" should {
    "validate correctly" in {
      ValidateBinarySearchTree98.isValidBST(TreeNode.createTree(5, 1, 4, null, null, 3, 6)) shouldBe false
//      ValidateBinarySearchTree98.isValidBST(TreeNode.createTree(2)) shouldBe true
//      ValidateBinarySearchTree98.isValidBST(TreeNode.createTree(2, 4, null)) shouldBe false
//      ValidateBinarySearchTree98.isValidBST(TreeNode.createTree(1, null, 1)) shouldBe false
//      ValidateBinarySearchTree98.isValidBST(TreeNode.createTree(2, 1, 3)) shouldBe true
//      ValidateBinarySearchTree98.isValidBST(TreeNode.createTree(
//        50,
//        -10,
//        80,
//        -20,
//        0,
//        60,
//        100,
//        -40,
//        -15,
//        -5,
//        20,
//        55,
//        70,
//        90,
//        110)) shouldBe true
//      ValidateBinarySearchTree98.isValidBST(TreeNode.createTree(
//        50,
//        -10,
//        80,
//        -20,
//        0,
//        60,
//        100,
//        -40,
//        -15,
//        -5,
//        50,
//        55,
//        70,
//        90,
//        110)) shouldBe false
    }
  }
}
