package contest.leetcode.graph

import contest.leetcode.testutil.Arrays.makeMatrix
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers.*
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

/**
 * @author Dmitry Openkov
 */
class NumberOfIslands200Test extends AnyWordSpec with ScalaCheckPropertyChecks {
  "NumberOfIslands" should {
    "find number of islands" in {
      val island1 =
        """
          1 1 1 1 1 1
          1 1 1 0 1 0
          1 1 0 0 0 0
          1 0 0 0 0 0
        """
      NumberOfIslands200.numIslands(makeMatrix(island1)(_.head)) shouldBe 1
      val island3 =
        """
          1 1 1 1 1 1
          1 1 1 0 1 0
          1 1 0 1 0 0
          1 0 0 0 1 1
          1 0 0 0 0 1
        """
      NumberOfIslands200.numIslands(makeMatrix(island3)(_.head)) shouldBe 3
    }
  }
}
