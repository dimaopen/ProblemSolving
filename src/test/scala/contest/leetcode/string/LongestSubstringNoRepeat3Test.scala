package contest.leetcode.string

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

/**
 * @author Dmitry Openkov
 */
class LongestSubstringNoRepeat3Test extends AnyWordSpec with ScalaCheckPropertyChecks {
  "MaximumSubarray" should {
    "find max sub-array sum in general" in {
      LongestSubstringNoRepeat3.lengthOfLongestSubstring("abcdabckoc") shouldBe 6
      LongestSubstringNoRepeat3.lengthOfLongestSubstring(" ") shouldBe 1
      LongestSubstringNoRepeat3.lengthOfLongestSubstring("abc") shouldBe 3
      LongestSubstringNoRepeat3.lengthOfLongestSubstring("") shouldBe 0
      LongestSubstringNoRepeat3.lengthOfLongestSubstring("a") shouldBe 1
      LongestSubstringNoRepeat3.lengthOfLongestSubstring("abcdabckocakf") shouldBe 6
    }
  }
}
