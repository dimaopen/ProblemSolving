package contest.leetcode.dp

import contest.leetcode.dp.Matrix542Test.makeMatrix
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

import scala.io.Source

/**
 * @author Dmitry Openkov
 */
class Matrix542Test extends AnyWordSpec with ScalaCheckPropertyChecks {
  "Matrix542" should {
    "find distances" in {
      val matrix1 =
        """
        1 1 1 0 1 1
        0 1 1 1 1 0
        1 1 1 1 1 1
        1 0 1 0 1 1
        """
      Matrix542.updateMatrix(makeMatrix(matrix1)).map(row => row.mkString(" ")).foreach(println)
      val expectedResult =
        """
          1 2 1 0 1 1
          0 1 2 1 1 0
          1 1 2 1 2 1
          1 0 1 0 1 2
        """
      Matrix542.updateMatrix(makeMatrix(matrix1)) shouldBe makeMatrix(expectedResult)
    }
  }
}

object Matrix542Test {
  def makeMatrix(matrix: String): Array[Array[Int]] = {
    matrix.split('\n').map(_.trim).filter(_.nonEmpty).map(_.split(' ').map(_.toInt))
  }
}
