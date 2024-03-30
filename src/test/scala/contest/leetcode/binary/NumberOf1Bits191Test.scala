package contest.leetcode.binary

import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.matchers.should.Matchers._

import scala.collection.BitSet

/**
 * @author Dmitry Openkov
 */
class NumberOf1Bits191Test extends AnyWordSpec with ScalaCheckPropertyChecks {
  "NumberOf1Bits191Test" should {
    "return correct hamming weight" in {
      NumberOf1Bits191.hammingWeight(-1) shouldBe 32
      NumberOf1Bits191.hammingWeight(32) shouldBe 1
      NumberOf1Bits191.hammingWeight(10) shouldBe 2
    }

    "return hamming weight for any integers" in {
      forAll { (a: Int) =>
        NumberOf1Bits191.hammingWeight(a) shouldBe numOnes(a)
      }
    }
  }

  private def numOnes(a: Int) = {
    if (a < 0)
      Integer.toString(Integer.MAX_VALUE + a + 1, 2).count(_ == '1') + 1
    else
      Integer.toString(a, 2).count(_ == '1')
  }
}
