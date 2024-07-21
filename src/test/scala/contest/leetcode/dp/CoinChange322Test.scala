package contest.leetcode.dp

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

/**
 * @author Dmitry Openkov
 */
class CoinChange322Test extends AnyWordSpec with ScalaCheckPropertyChecks {
  "CoinChange" should {
    "find min number of coins in general" in {
      CoinChange322.coinChange(coins = Array(1, 2, 5), amount = 11) shouldBe 3
    }
    "report it's impossible" in {
      CoinChange322.coinChange(coins = Array(3), amount = 5) shouldBe -1
      CoinChange322.coinChange(coins = Array(2), amount = 3) shouldBe -1
      CoinChange322.coinChange(coins = Array(4,5), amount = 11) shouldBe -1
      CoinChange322.coinChange(coins = Array(3,4,5), amount = 2) shouldBe -1
    }
    "min number is zero" in {
      CoinChange322.coinChange(coins = Array(1, 2, 5), amount = 0) shouldBe 0
    }
  }
  "CoinChangeBack" should {
    "find min number of coins in general" in {
      CoinChange322.coinChangeBack(coins = Array(1, 2, 5), amount = 11) shouldBe 3
      CoinChange322.coinChangeBack(coins = Array(2,3), amount = 7) shouldBe 3
    }
    "report it's impossible" in {
      CoinChange322.coinChangeBack(coins = Array(3), amount = 5) shouldBe -1
      CoinChange322.coinChangeBack(coins = Array(2), amount = 3) shouldBe -1
      CoinChange322.coinChangeBack(coins = Array(4,5), amount = 11) shouldBe -1
      CoinChange322.coinChangeBack(coins = Array(3,4,5), amount = 2) shouldBe -1
    }
    "min number is zero" in {
      CoinChange322.coinChangeBack(coins = Array(1, 2, 5), amount = 0) shouldBe 0
    }
  }
}
