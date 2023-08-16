package contest.leetcode

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.matchers.should.Matchers._


/**
 * @author Dmitry Openkov
 */
class SlidingSubarrayBeautyTest extends AnyFlatSpec with ScalaCheckPropertyChecks {
  "SlidingSubarrayBeautyTest" should "find beauty" in {
    SlidingSubarrayBeauty.getSubarrayBeauty(Array[Int](1, -1, -3, -2, 3), k = 3, x = 2) shouldBe Array(-1, -2, -2)
    SlidingSubarrayBeauty.getSubarrayBeauty(Array[Int](-1,-2,-3,-4,-5), k = 2, x = 2) shouldBe Array(-1,-2,-3,-4)
    SlidingSubarrayBeauty.getSubarrayBeauty(Array[Int](-3,1,2,-3,0,-3), k = 2, x = 1) shouldBe Array(-3,0,-3,-3,-3)
  }
}
