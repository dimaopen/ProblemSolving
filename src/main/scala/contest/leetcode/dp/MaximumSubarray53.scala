package contest.leetcode.dp

/**
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * @author Dmitry Openkov
 */
object MaximumSubarray53 {
  case class Agg(maxSum: Int, currentSum: Int)

  def maxSubArray(nums: Array[Int]): Int = {
    nums.foldLeft(Agg(nums.head, 0)) {
      case (Agg(maxSum, currentSum), x) if currentSum + x < 0 => Agg(math.max(maxSum, currentSum + x), 0)
      case (Agg(maxSum, currentSum), x) => Agg(math.max(maxSum, currentSum + x), currentSum + x)
    }.maxSum
  }
}