package contest.leetcode

import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

/**
 * @author Dmitry Openkov
 */
class NumberWaysBuyPensPencils2240Test extends AnyWordSpec with ScalaCheckPropertyChecks {
  "NumberWaysBuyPensPencils" should {
    "find number of ways to buy pens and pencils" in {
      NumberWaysBuyPensPencils2240.waysToBuyPensPencils(20, 10, 5) shouldBe 9
      NumberWaysBuyPensPencils2240.waysToBuyPensPencils(5, 10, 5) shouldBe 2
      NumberWaysBuyPensPencils2240.waysToBuyPensPencils(5, 10, 10) shouldBe 1
    }
  }

}
