package contest.leetcode.array

import scala.collection.View

/**
 * @author Dmitry Openkov
 */
object CombinationSum39:

  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    def go(nums: List[Int], left: Int, path: List[Int]): List[List[Int]] =
      if (left < 0) Nil
      else if (left == 0) List(path)
      else {
        nums match {
          case Nil => Nil
          case x :: xs => go(nums, left - x, x :: path) ::: go(xs, left, path)
        }
      }

    go(candidates.toList, target, Nil)
  }


  def combinationSum2(candidates: Array[Int], target: Int): List[List[Int]] =
    def go(target: Int, combination: List[Int]): View[List[Int]] =
      val (finished, notFinished) = candidates.view
        .collect { case candidate if target - candidate >= 0 =>
          target - candidate -> (candidate :: combination)
        }
        .partition { case (i, combination) => i == 0 }

      finished.map(_._2) ++ notFinished.flatMap(go)

    go(target, List.empty).map(_.sorted).toList.distinct
