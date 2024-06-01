package contest.leetcode.graph

import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import contest.leetcode.testutil.Arrays.toArray

import scala.collection.mutable

/**
 * @author Dmitry Openkov
 */
class CourseSchedule207Test extends AnyWordSpec {
  "CourseSchedule" should {
    "validate possibility" in {
      CourseSchedule207.canFinish(2, Array((1, 0))) shouldBe true
      CourseSchedule207.canFinish(2, Array((1, 0), (0, 1))) shouldBe false
      CourseSchedule207.canFinish(6, Array((1, 2), (1, 3), (1, 4), (3, 0), (4, 2), (4, 5))) shouldBe true
      CourseSchedule207.canFinish(7,
        Array((1, 2), (1, 3), (1, 4), (3, 0), (3, 6), (4, 2), (4, 5), (6, 1))) shouldBe false
    }
  }
}
