package contest.leetcode


object SlidingSubarrayBeauty {
  import scala.collection.mutable.ArrayBuffer
  import scala.collection.Searching._
  def getSubarrayBeauty(nums: Array[Int], k: Int, x: Int): Array[Int] = {
    val firstArray = nums.slice(0, k)
    val sortedNegative = ArrayBuffer[Int](firstArray.filter(_ < 0): _*).sorted
    def getXth = if (sortedNegative.size > x - 1) sortedNegative(x - 1) else 0

    val first = getXth

    val startingRange = 0 until nums.length - k
    val endingRange = k until nums.length
    val result = first +: startingRange.map { i =>
      val removed = nums(i)
      if (removed < 0) {
        sortedNegative.search(removed) match {
          case Found(foundIndex) => sortedNegative.remove(foundIndex)
          case _ =>
        }
      }
      val added = nums(endingRange(i))
      if (added < 0) {
        sortedNegative.insert(sortedNegative.search(added).insertionPoint, added)
      }
      getXth
    }
    result.toArray
  }
}