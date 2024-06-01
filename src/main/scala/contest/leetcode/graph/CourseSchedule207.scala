package contest.leetcode.graph

import scala.util.boundary

/**
 * @author Dmitry Openkov
 */
object CourseSchedule207 {
  // [0, 1], 1 first
  // 1 -> 2, 1 -> 3
  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
    val dependsOn: Map[Int, Array[Int]] = prerequisites.groupMap(_(0))(_(1))

    def go(orig: Int, course: Int, dependsOn: Map[Int, Array[Int]]): (Boolean, Map[Int, Array[Int]]) = {
      val deps = dependsOn.getOrElse(course, Array.empty[Int])
      if deps.isEmpty then
        (true, dependsOn)
      else if deps.contains(orig) then
        (false, dependsOn)
      else boundary {
        (true, deps.foldLeft(dependsOn) { case (dependsOn, dep) =>
          val (depResult, newDependsOn) = go(orig, dep, dependsOn)
          if !depResult then boundary.break((false, newDependsOn))
          newDependsOn - dep
        })
      }
    }

    boundary {
      dependsOn.keys.foldLeft(dependsOn) { case (dependsOn, course) =>
        val (depResult, newDependsOn) = go(course, course, dependsOn)
        if !depResult then boundary.break(false)
        newDependsOn - course
      }.isEmpty
    }
  }
}
