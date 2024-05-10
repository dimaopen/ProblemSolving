package contest.leetcode.array
import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

/**
 * @author Dmitry Openkov
 */
class ThreeSum15Test extends AnyWordSpec with ScalaCheckPropertyChecks {

  "3Sum" should {
    "return all the zero triplets" in {
      ThreeSum15.threeSum(Array(0,0,0)) should contain theSameElementsAs List(List(0, 0, 0))
      ThreeSum15.threeSum(Array(0,0,0,0,0,0)) should contain theSameElementsAs List(List(0, 0, 0))
      ThreeSum15.threeSum(Array(-1,0,1)) should contain theSameElementsAs List(List(-1, 0, 1))
      ThreeSum15.threeSum(Array(-1,0,1,2,-1,-4)) should contain theSameElementsAs List(List(-1, 0, 1), List(-1, -1, 2))
      ThreeSum15.threeSum(Array(-1,0,0,1,2,-1,-4)) should contain theSameElementsAs List(List(-1, 0, 1), List(-1, -1, 2))
      ThreeSum15.threeSum(Array(-1,0,1,2,0,-1,0,-4)) should contain theSameElementsAs List(List(-1, 0, 1), List(0, 0, 0), List(-1, -1, 2))
      ThreeSum15.threeSum(Array(-1,0,1,2,0,-1,0,-4,0)) should contain theSameElementsAs List(List(-1, 0, 1), List(0, 0, 0), List(-1, -1, 2))
    }
  }
}
