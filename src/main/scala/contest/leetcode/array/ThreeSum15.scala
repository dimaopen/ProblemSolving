package contest.leetcode.array

/**
 * @author Dmitry Openkov
 */
object ThreeSum15 {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val counted = nums.groupBy(x => x).view.mapValues(_.length).toMap

    val result = for {
      (x, numX) <- counted
      (y, numY) <- counted if x != y || numX >= 2
      z = -(x + y)
      _ <- counted.get(z) if (x != z || numX >= 2) && (y != z || numY >= 2) && (y != x || numX >= 3)
    } yield List(x, y, z).sorted

    result.toSet.toList
  }
}
