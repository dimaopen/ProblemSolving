package contest.leetcode

object StringToInteger {
  def myAtoi(s: String): Int = {
    val regex = "^ *([-+]?\\d+)".r
    regex.findFirstMatchIn(s) match {
      case Some(m) =>
        val value = BigInt(m.group(1))
        if (value > Int.MaxValue) Int.MaxValue
        else if (value < Int.MinValue) Int.MinValue
        else value.toInt
      case None => 0
    }
  }
}