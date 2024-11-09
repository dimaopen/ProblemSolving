package contest.leetcode.array

import scala.annotation.tailrec

/**
 * @author Dmitry Openkov
 */
object SearchInRotatedSortedArray33 {
  def search(nums: Array[Int], target: Int): Int =
    @tailrec
    def go(lo: Int, hi: Int): Int =
      if lo < hi then
        val mid = (lo + hi) / 2
        // if we replace the rotated values with negative or positive infinity then we can use  regular binary search
        // 7 8 9 0 1 2 3 4 5 6 in this array if both current value and the target no the same side fo the cliff
        // then we use the current value otherwise we should use negative or possible infinity
        val numOrInfinity = nums(mid) match
          case x if x < nums.head == target < nums.head => x
          case x if target < x => Int.MinValue
          case _ => Int.MaxValue
        // do regular binary search
        numOrInfinity match
          case x if x == target => mid
          case x if x > target => go(lo, mid)
          case x if x < target => go(lo + 1, hi)
      else
        -1

    go(0, nums.length)
}
