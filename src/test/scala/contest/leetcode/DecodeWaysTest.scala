package contest.leetcode

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.matchers.should.Matchers._

/**
 * @author Dmitry Openkov
 */
class DecodeWaysTest extends AnyFlatSpec with ScalaCheckPropertyChecks {
  "DecodeWaysTest" should "find number of ways to decode" in {
    DecodeWays.numDecodings("10") shouldBe 1
    DecodeWays.numDecodings("106") shouldBe 1
    DecodeWays.numDecodings("11111") shouldBe 8
    DecodeWays.numDecodings("1136") shouldBe 3
    DecodeWays.numDecodings("12") shouldBe 2
    DecodeWays.numDecodings("226") shouldBe 3
    DecodeWays.numDecodings("06") shouldBe 0
    DecodeWays.numDecodings("1126") shouldBe 5
    DecodeWays.numDecodings("9282") shouldBe 1
    DecodeWays.numDecodings("92802") shouldBe 0
    DecodeWays.numDecodings("11911") shouldBe 6
  }

}
