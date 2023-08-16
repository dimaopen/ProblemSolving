package contest.leetcode


/**
 * @author Dmitry Openkov
 */
object StepsMakeArrayNonDecreasing2289 {

  import scala.math.max

  def totalSteps(nums: Array[Int]): Int = {
    nums.tail
      .foldLeft((List((nums.head, 0)), 0)) { case ((stack, result), a) =>
        val (removed, left) = stack.span(_._1 <= a)
        val t = if (left.nonEmpty)
                  removed.maxByOption(_._2).fold(0)(_._2) + 1
                else 0
        ((a, t) :: left, max(result, t))
      }
  }._2
}
