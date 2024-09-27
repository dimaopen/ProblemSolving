package contest.leetcode.array
import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

/**
 * @author Dmitry Openkov
 */
class ProductOfArrayExceptSelf238Test extends AnyWordSpec with ScalaCheckPropertyChecks {

  "ProductOfArrayExceptSelf238" should {
    "return product except same element" in {
      ProductOfArrayExceptSelf238.productExceptSelf(Array(1, 2, 3, 4)) shouldBe Array(24, 12, 8, 6)
      ProductOfArrayExceptSelf238.productExceptSelf(Array(-1,1,0,-3,3)) shouldBe Array(0, 0, 9, 0, 0)
    }
  }
}
