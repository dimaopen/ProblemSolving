package contest.leetcode

import org.scalacheck.Gen
import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

/**
 * @author Dmitry Openkov
 */
class MedianOfTwoSortedArraysTest extends AnyWordSpec with ScalaCheckPropertyChecks {
  "MedianOfTwoSortedArrays" should {
    "find median" in {
      val genIntArray = Gen.choose(0, 1000).flatMap(n =>
        Gen.containerOfN[Array, Int](n, Gen.chooseNum(-1000000, 1000000, 1000, -100))
      ).map(_.sorted)
      // for some reason not all arrays sorted...
      forAll(genIntArray, genIntArray) { case (a, b) =>
        whenever(a.length + b.length >= 1) {
          val m = MedianOfTwoSortedArrays.median((a ++ b).sorted)
          MedianOfTwoSortedArrays.findMedianSortedArrays(a, b) shouldBe m
        }
      }
    }

    "produce correct result in debug cases" in {
      MedianOfTwoSortedArrays.findMedianSortedArrays(Array(1, 2), Array(1, 2, 3)) shouldBe 2
    }
  }
}
