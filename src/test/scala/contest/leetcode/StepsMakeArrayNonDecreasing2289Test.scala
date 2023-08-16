package contest.leetcode

import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

import scala.io.Source

/**
 * @author Dmitry Openkov
 */
class StepsMakeArrayNonDecreasing2289Test extends AnyWordSpec with ScalaCheckPropertyChecks {
  "StepsMakeArrayNonDecreasing2289" should {
    "find steps" in {
      StepsMakeArrayNonDecreasing2289.totalSteps(Array(10,1,2,3,4,5,6,1,2,3)) shouldBe 6
      StepsMakeArrayNonDecreasing2289.totalSteps(Array(5, 4, 3, 2, 1)) shouldBe 1
      StepsMakeArrayNonDecreasing2289.totalSteps(Array(5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11)) shouldBe 3
      StepsMakeArrayNonDecreasing2289.totalSteps(Array(5, 6)) shouldBe 0
      StepsMakeArrayNonDecreasing2289.totalSteps(Array(5)) shouldBe 0
    }
    "find steps in big arrays" in {
      val loadedArray = Source.fromResource("rnd_arr_10000.txt").getLines().next().split(',').map(_.toInt)
      StepsMakeArrayNonDecreasing2289.totalSteps(loadedArray) shouldBe 17599
    }
  }

}
