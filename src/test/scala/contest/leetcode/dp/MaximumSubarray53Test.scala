package contest.leetcode.dp

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

/**
 * @author Dmitry Openkov
 */
class MaximumSubarray53Test extends AnyWordSpec with ScalaCheckPropertyChecks {
  "MaximumSubarray" should {
    "find max sub-array sum in general" in {
      MaximumSubarray53.maxSubArray(Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)) shouldBe 6
      MaximumSubarray53.maxSubArray(Array(2, 3, 9, -5, -6, 1, 9, 9, 9, -1, -2)) shouldBe 31
    }
    "return the only element" in {
      MaximumSubarray53.maxSubArray(Array(-2)) shouldBe -2
      MaximumSubarray53.maxSubArray(Array(0)) shouldBe 0
      MaximumSubarray53.maxSubArray(Array(1)) shouldBe 1
    }
    "return the whole array" in {
      MaximumSubarray53.maxSubArray(Array(5, 4, -1, 7, 8)) shouldBe 23
    }
    "all negatives" in {
      MaximumSubarray53.maxSubArray(Array(-2, -1)) shouldBe -1
    }
  }
}
