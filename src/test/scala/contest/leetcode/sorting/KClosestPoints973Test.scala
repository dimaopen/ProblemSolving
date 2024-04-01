package contest.leetcode.sorting

import contest.leetcode.testutil.Arrays.toTuple2
import contest.leetcode.testutil.Arrays.toArray2
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

/**
 * @author Dmitry Openkov
 */
class KClosestPoints973Test extends AnyWordSpec with ScalaCheckPropertyChecks {
  "KClosestPoints" should {
    "find k closest points" in {
      KClosestPoints973.kClosest(Array((3, 3), (5, -1), (-2, 4)), 2)
        .map(toTuple2) should contain theSameElementsAs Array((-2, 4), (3, 3))
    }

  }
}
