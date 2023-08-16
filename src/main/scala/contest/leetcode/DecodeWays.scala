package contest.leetcode

object DecodeWays {
  case class Accum(ways1: Int, ways0: Int, prev: Int)

  def numDecodings(s: String): Int = {
    val digits = s.view.map(_.asDigit) :+ 1
    val initialValue = Accum(1, if (digits.head == 0) 0 else 1, digits.head)
    digits.tail.foldLeft(initialValue) { case (Accum(ways2, ways1, prev), current) =>
      val (x1, x2) = calcWays(prev, current)
      val currentResult = (if (x1) ways1 else 0) + (if (x2) ways2 else 0)
      Accum(ways1, currentResult, current)
    }.ways1
  }

  private def calcWays(prev: Int, current: Int): (Boolean, Boolean) = {
    val twoDigitNo = 10 * prev + current
    (current >= 1 && current <= 9) -> (twoDigitNo >= 10 && twoDigitNo <= 26)
  }

}