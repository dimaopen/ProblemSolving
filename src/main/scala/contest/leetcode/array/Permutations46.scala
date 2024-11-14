package contest.leetcode.array

/**
 * @author Dmitry Openkov
 */
object Permutations46:
  def permute(nums: Array[Int]): List[List[Int]] =
    def go(nums: Set[Int], path: List[Int]): Set[List[Int]] =
      if nums.isEmpty then Set(path)
      else nums.flatMap { x =>
        go(nums - x, x :: path)
      }

    go(nums.toSet, Nil).toList

