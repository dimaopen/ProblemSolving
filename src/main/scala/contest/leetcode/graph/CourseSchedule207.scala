package contest.leetcode.graph

import scala.annotation.tailrec

/**
 * @author Dmitry Openkov
 */
object CourseSchedule207:
  // [0, 1], 1 first
  // 1 -> 2, 1 -> 3
  // n*n/2 solution. Slow but clean. In a cycle we remove courses that don't depend on any others.
  // until we cannot do it or the map is empty
  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean =
    @tailrec
    def go(dependsOn: Map[Int, Array[Int]]): Map[Int, Array[Int]] =
      val newDependsOn = dependsOn.view
        .mapValues(_.filter(dependsOn.contains))
        .filter{case (_, deps) => deps.nonEmpty}
        .toMap
      if dependsOn.size == newDependsOn.size then dependsOn
      else go(newDependsOn)

    val dependsOn: Map[Int, Array[Int]] = prerequisites.groupMap(_(0))(_(1))
    go(dependsOn).isEmpty


end CourseSchedule207

