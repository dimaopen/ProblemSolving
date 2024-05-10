package contest.leetcode.tree

/**
 * @author Dmitry Openkov
 */
object EvaluateReversePolishNotation150 {
  def evalRPN(tokens: Array[String]): Int = {

    sealed trait Expression {
      def eval: Int
    }
    case class FullExpression(a: Expression, b: Expression, op: String) extends Expression {
      override def eval: Int = {
        op match {
          case "+" => a.eval + b.eval
          case "-" => a.eval - b.eval
          case "*" => a.eval * b.eval
          case "/" => a.eval / b.eval
        }
      }
    }
    case class IntExp(eval: Int) extends Expression

    val ops = Set("+", "-", "*", "/")

    tokens.foldLeft(List.empty[Expression]) {
      case (stack, token) if ops.contains(token) =>
        val b :: a :: newStack = stack
        FullExpression(a, b, token) :: newStack
      case (stack, token) =>
        IntExp(token.toInt) :: stack
    }.head.eval

  }
}