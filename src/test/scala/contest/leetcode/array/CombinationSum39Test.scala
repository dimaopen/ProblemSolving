package contest.leetcode.array

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

/**
 * @author Dmitry Openkov
 */
class CombinationSum39Test extends AnyWordSpec {

  "CombinationSum39" when {
    "given candidates and a target" should {
      "find all the unique combinations" in {
        CombinationSum39.combinationSum(Array(2, 3, 6, 7), target = 7) should contain theSameElementsAs List(
          List(2, 2, 3), List(7)
        )
        CombinationSum39.combinationSum(Array(2, 3, 5), target = 8) should contain theSameElementsAs List(
          List(2, 2, 2, 2),
          List(2, 3, 3),
          List(3, 5)
        )
      }
    }
    "given impossible target" should {
      "return an empty list" in {
        CombinationSum39.combinationSum(Array(6, 7), target = 15) shouldBe empty
        CombinationSum39.combinationSum(Array(6, 7), target = 5) shouldBe empty
      }
    }
  }
}
