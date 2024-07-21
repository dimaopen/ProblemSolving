package contest.leetcode.dp

/**
 * @author Dmitry Openkov
 */
object CoinChange322:
  def coinChange(coins: Array[Int], amount: Int): Int =
    val memory = Array.fill[Int](amount + 1)(-1)
    memory(0) = 0

    def getNumberOfCoins(value: Int): Int =
      if value < 0 then -1
      else memory(value)

    for (x <- coins.min to amount) {
      coins
        .map(coin => getNumberOfCoins(x - coin))
        .filter(_ >= 0)
        .minOption
        .foreach(value => memory(x) = value + 1)
    }
    memory(amount)

  def coinChangeBack(coins: Array[Int], amount: Int): Int =
    val memory = Array.ofDim[Int](amount + 1)

    def go(rem: Int): Int =
      rem match
        case 0 =>
          0
        case x if x < 0 =>
          -1
        case x if memory(x) > 0 =>
          memory(x)
        case _ =>
          val res = coins
            .map(coin => go(rem - coin))
            .filter(_ >= 0)
            .minOption
            .getOrElse(-1)
          memory(rem) = if res < 0 then -1 else res + 1
          memory(rem)

    go(amount)


end CoinChange322