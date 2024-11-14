package contest.leetcode.array

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

/**
 * @author Dmitry Openkov
 */
class Permutations46Test extends AnyWordSpec {

  "Permutations" when {
    "given a regular array" should {
      "find all the permutations" in {
        Permutations46.permute(Array(1, 2, 3)) should contain theSameElementsAs List(
          List(1, 2, 3),
          List(1, 3, 2),
          List(2, 1, 3),
          List(2, 3, 1),
          List(3, 1, 2),
          List(3, 2, 1)
        )
        Permutations46.permute(Array(0, 1)) should contain theSameElementsAs List(
          List(0, 1),
          List(1, 0),
        )
        Permutations46.permute(Array(0)) should contain theSameElementsAs List(
          List(0),
        )
      }
    }
  }
}
