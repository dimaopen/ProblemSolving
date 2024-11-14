package contest.leetcode.geometry

import scala.annotation.nowarn
import contest.leetcode.geometry._

/**
 * @author Dmitry Openkov
 */
object MergeIntervals56:

  /**
   * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
   * and return an array of the non-overlapping intervals that cover all the intervals in the input.
   */
  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] =
    val sorted = intervals.sortBy(_.start)
    sorted.tail.foldLeft(IndexedSeq(sorted.head)) {
      case (rest :+ last, interval) => rest :++ last.merge(interval)
    }.toArray

