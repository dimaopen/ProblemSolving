package contest.leetcode.string

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * @author Dmitry Openkov
 */
object LongestSubstringNoRepeat3 {
  def lengthOfLongestSubstring(s: String): Int =
    s.view.scanLeft(List.empty[Char])((curSeq, c) => c :: curSeq.takeWhile(_ != c)).map(_.size).max

}