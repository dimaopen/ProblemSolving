package contest.leetcode.array

import contest.leetcode.geometry._

/**
 * https://leetcode.com/problems/insert-interval/
 *
 * @author Dmitry Openkov
 */
object InsertInterval57 {
  def insert(intervals: Array[Array[Int]], newInterval: Array[Int]): Array[Array[Int]] = {
    val (begin, next) = intervals.span(_.end < newInterval.start)
    val (mid, end) = next.span(_.start <= newInterval.end)
    val middle = mid.headOption.fold(newInterval) { midFirst =>
      Array(midFirst.start min newInterval.start, mid.last.end max newInterval.end) }
    (begin :+ middle) ++ end
  }
}
