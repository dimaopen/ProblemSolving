package contest.leetcode.graph

import contest.leetcode.testutil.Arrays.makeMatrix
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers.*
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

/**
 * @author Dmitry Openkov
 */
class RottingOranges994Test extends AnyWordSpec with ScalaCheckPropertyChecks {
  "RottingOranges" should {
    "find number of minutes until no fresh ones" in {
      val regular =
        """
        2 1 1
        1 1 0
        0 1 1
        """
      RottingOranges994.orangesRotting(makeMatrix(regular)) shouldBe 4
      val survived =
        """
        2 1 1
        0 1 1
        1 0 1
        """
      RottingOranges994.orangesRotting(makeMatrix(survived)) shouldBe -1
      val already =
        """
        2 0 0
        2 0 0
        0 2 2
        0 0 0
        0 0 2
        """
      RottingOranges994.orangesRotting(makeMatrix(already)) shouldBe 0
      val empty =
        """
        0 0 0 0 0
        0 0 0 0 0
        0 0 0 0 0
        """
      RottingOranges994.orangesRotting(makeMatrix(already)) shouldBe 0
    }
  }
}
