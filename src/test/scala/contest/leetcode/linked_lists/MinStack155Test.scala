package contest.leetcode.linked_lists

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

/**
 * @author Dmitry Openkov
 */
class MinStack155Test extends AnyWordSpec:
  "MinStack" should {
    "be a stack with min operation" in {
      val minStack = MinStack155()
      minStack.push(-2)
      minStack.push(0)
      minStack.push(-3)
      minStack.getMin() shouldBe -3
      minStack.pop()
      minStack.top() shouldBe 0
      minStack.getMin() shouldBe -2
    }
  }
end MinStack155Test