package contest.leetcode.binary

/**
 * @author Dmitry Openkov
 */
object NumberOf1Bits191 {
  def hammingWeight1(n: Int): Int = {
    (0 until 32).map(1 << _).map(n & _).count(_ != 0)
  }

  def hammingWeight(n: Int): Int = {
    var m = n
    var res = 0
    while (m != 0) {
      m &= m - 1 // better than this more convoluted one: m -= -m & m
      res += 1
    }
    res
  }
}
