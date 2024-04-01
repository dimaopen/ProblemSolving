package contest.leetcode.sorting

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * @author Dmitry Openkov
 */
object KClosestPoints973 {
  def kClosest(points: Array[Array[Int]], k: Int): Array[Array[Int]] = {
    case class Point(d: Int, data: Array[Int])
    val pq = scala.collection.mutable.PriorityQueue.empty[Point](Ordering.by(_.d))

    points.foreach { p =>
      pq.enqueue(Point(p(0) * p(0) + p(1) * p(1), p))
      if (pq.length > k) pq.dequeue()
    }

    pq.dequeueAll.map((_: Point).data).toArray
  }
}
