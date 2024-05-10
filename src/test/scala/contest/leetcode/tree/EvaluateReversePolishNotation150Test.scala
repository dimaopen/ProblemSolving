package contest.leetcode.tree
import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

/**
 * @author Dmitry Openkov
 */
class EvaluateReversePolishNotation150Test extends AnyWordSpec with ScalaCheckPropertyChecks {

  "EvaluateReversePolishNotation" should {
    "calculate arbitrary expression" in {
      EvaluateReversePolishNotation150.evalRPN(Array("2","1","+","3","*")) shouldBe 9
      EvaluateReversePolishNotation150.evalRPN(Array("4","13","5","/","+")) shouldBe 6
      EvaluateReversePolishNotation150.evalRPN(Array("10","6","9","3","+","-11","*","/","*","17","+","5","+")) shouldBe 22
    }
    "calculate simple expression" in {
      EvaluateReversePolishNotation150.evalRPN(Array("-13")) shouldBe -13
    }
  }
}
