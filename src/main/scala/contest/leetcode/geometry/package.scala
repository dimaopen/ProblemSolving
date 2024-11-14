package contest.leetcode

/**
 * @author Dmitry Openkov
 */
package object geometry:
  // 2 element array is an interval
  type Interval = Array[Int]

  extension (interval: Interval)
    def start: Int = interval.head
    def end: Int = interval.last
    /**
     * Merges 2 sorted by start intervals
     * @param other the other interval (`this.start <= other.start`)
     * @return a seq contains the merged interval or both intervals if they don't overlap
     */
    def merge(other: Interval): Seq[Interval] =
      if interval.end >= other.start then
        Seq(Array(interval.start, math.max(interval.end, other.end)))
      else
        Seq(interval, other)
  


