package contest.leetcode.geometry

import contest.leetcode.testutil.Arrays.toArray
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

/**
 * @author Dmitry Openkov
 */
class MergeIntervals56Test extends AnyWordSpec {

  "MergeIntervals" when {
    "given overlapping intervals" should {
      "merge them correctly" in {
        MergeIntervals56.merge(Array(
          (1, 3),
          (2, 6),
          (8, 10),
          (15, 18))
        ) should contain theSameElementsAs Array[Interval](
          (1, 6),
          (8, 10),
          (15, 18),
        )
      }
    }
    "given not overlapping intervals" should {
      "return the same intervals" in {
        MergeIntervals56.merge(Array(
          (1, 3),
          (4, 6),
          (8, 10),
          (15, 18))
        ) should contain theSameElementsAs Array[Interval](
          (1, 3),
          (4, 6),
          (8, 10),
          (15, 18),
        )
      }
    }
    "given a single interval" should {
      "return this interval" in {
        MergeIntervals56.merge(Array((1, 3))) should contain theSameElementsAs Array[Interval](
          (1, 3),
        )
      }
    }
    "given 2 intervals where the smaller one is inside the bigger one" should {
      "return the bigger one" in {
        MergeIntervals56.merge(Array((1, 4), (2, 3))) should contain theSameElementsAs Array[Interval](
          (1, 4),
        )
      }
    }
  }
}
