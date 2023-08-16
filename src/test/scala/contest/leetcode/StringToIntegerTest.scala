package contest.leetcode

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.matchers.should.Matchers._

/**
 * @author Dmitry Openkov
 */
class StringToIntegerTest extends  AnyFlatSpec with ScalaCheckPropertyChecks {
  "StringToInteger" should "convert a string to the corresponding integer" in {
    StringToInteger.myAtoi("   -33") shouldBe -33
    StringToInteger.myAtoi("   -33.asdf") shouldBe -33
    StringToInteger.myAtoi("\t   -33.asdf") shouldBe 0
    StringToInteger.myAtoi("   34000000000.asdf") shouldBe Int.MaxValue
  }

}
