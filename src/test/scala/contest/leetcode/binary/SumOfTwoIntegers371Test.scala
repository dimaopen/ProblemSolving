package contest.leetcode.binary

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

/**
 * @author Dmitry Openkov
 */
class SumOfTwoIntegers371Test extends AnyWordSpec with ScalaCheckPropertyChecks {
  "SumOfTwoIntegers" should {
    "return correct sum" in {
      SumOfTwoIntegers371.getSum(3, 3) shouldBe 6
      SumOfTwoIntegers371.getSum(4, 4) shouldBe 8
      SumOfTwoIntegers371.getSum(10, 5) shouldBe 15
      SumOfTwoIntegers371.getSum(15, 4) shouldBe 19
      SumOfTwoIntegers371.getSum(255, 16) shouldBe 271
    }

    "return sum for any integers" in {
      forAll { (a: Int, b: Int) =>
        SumOfTwoIntegers371.getSum(a, b) shouldBe a + b
      }
    }
  }


}
