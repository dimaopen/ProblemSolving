package contest.leetcode.binary

import scala.annotation.tailrec

/**
 * @author Dmitry Openkov
 */
object SumOfTwoIntegers371 {
  @tailrec
  def getSum(a: Int, b: Int): Int = {
    if (b == 0) a
    else {
      getSum(a ^ b, (a & b) << 1)
    }
  }
}
