package contest.leetcode

/**
 * @author Dmitry Openkov
 */
object MedianOfTwoSortedArrays extends App {
  import scala.annotation.tailrec
  import scala.collection.Searching
  
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    if (nums1.length == 0) return median(nums2)
    else if (nums2.length == 0) return median(nums1)
    
    val m1 = median(nums1)
    val m2 = median(nums2)
    
    val (left, leftAr, right, rightAr) = if (m1 < m2) (m1, nums1, m2, nums2) else (m2, nums2, m1, nums1)

    def medianDiff(x: Double, leftFrom: Int, rightTo: Int): (Int, Int, Int) = {
      val toSearch = math.ceil(x).toInt
      val inBetween = if (toSearch.toDouble != x) 0 else 1
      val (leftPos, leftContains) = leftAr.search(toSearch, leftFrom, leftAr.length) match {
        case Searching.Found(foundIndex) => foundIndex -> inBetween
        case Searching.InsertionPoint(insertionPoint) => insertionPoint -> 0
      }
      val (rightPos, rightContains) = rightAr.search(toSearch, 0, rightTo) match {
        case Searching.Found(foundIndex) => foundIndex -> inBetween
        case Searching.InsertionPoint(insertionPoint) => insertionPoint -> 0
      }

      val leftNum = leftPos + rightPos
      val rightNum = (leftAr.length - leftPos - leftContains) + (rightAr.length - rightPos - rightContains)
      (leftNum - rightNum, leftPos, rightPos)
    }

    @tailrec
    def _rec(left: Double, right: Double, leftFrom: Int, rightTo: Int): Double = {
      if (left == right) return left
      val avg = math.round(left + right) / 2.0
      val (mDiff, newLeftFrom, newRightTo) = medianDiff(avg, leftFrom, rightTo)
      if (mDiff == 0) avg
      else if (mDiff < 0 && right - left == 0.5) right
      else if (mDiff > 0 && right - left == 0.5) left
      else if (mDiff < 0) _rec(avg, right, newLeftFrom, rightTo)
      else _rec(left, avg, leftFrom, newRightTo)
    }

    _rec(left, right, leftAr.length / 2, rightAr.length / 2 + 1)
  }

  def median(nums: Array[Int]): Double = {
    import scala.math.Integral.Implicits._
    val (middle, rem) = nums.length /% 2
    if (rem == 0) (nums(middle - 1) + nums(middle)) / 2.0
    else nums(middle).toDouble
  }

  val result = findMedianSortedArrays(Array(1, 2), Array(1, 2, 3))
  println(result)

}
