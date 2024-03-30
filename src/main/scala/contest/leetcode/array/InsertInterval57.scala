package contest.leetcode.array

/**
 * https://leetcode.com/problems/insert-interval/
 *
 * @author Dmitry Openkov
 */
object InsertInterval57 {
  implicit class Interval(val self: Array[Int]) extends AnyVal {
    def start: Int = self.head

    def end: Int = self.last
  }
  def insert(intervals: Array[Array[Int]], newInterval: Array[Int]): Array[Array[Int]] = {
    val (begin, next) = intervals.span(_.end < newInterval.start)
    val (mid, end) = next.span(_.start <= newInterval.end)
    val middle = mid.headOption.fold(newInterval) { midFirst =>
      Array(midFirst.start min newInterval.start, mid.last.end max newInterval.end) }
    (begin :+ middle) ++ end
  }
}
