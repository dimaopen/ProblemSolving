package contest.leetcode.array

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

import scala.language.implicitConversions
import scala.reflect.ClassTag

/**
 * @author Dmitry Openkov
 */
class InsertInterval57Test extends AnyWordSpec with ScalaCheckPropertyChecks {
  def toTuple[T](array: Array[T]): (T, T) = (array(0), array(1))

  implicit def toArray[T: ClassTag](t: (T, T)): Array[T] = Array(t._1, t._2)

  "MaximumSubarray" should {
    "insert a new interval in the middle" in {
      InsertInterval57.insert(Array((1, 3), (6, 9)), (4, 5)).map(toTuple) shouldBe Array((1, 3), (4, 5), (6, 9))
    }
    "insert a new interval" in {
      InsertInterval57.insert(Array((1, 3), (6, 9)), (2, 5)).map(toTuple) shouldBe Array((1, 5), (6, 9))
      InsertInterval57.insert(Array((1, 2), (3, 5), (6, 7), (8, 10), (12, 16)), (4, 8))
        .map(toTuple) shouldBe Array((1, 2), (3, 10), (12, 16))
    }
    "insert a new interval at beginning" in {
      InsertInterval57.insert(Array((3, 5), (6, 7), (8, 10), (12, 16)), (1, 2))
        .map(toTuple) shouldBe Array((1, 2), (3, 5), (6, 7), (8, 10), (12, 16))
    }
    "insert a new interval at beginning connected" in {
      InsertInterval57.insert(Array((3, 5), (6, 7), (8, 10), (12, 16)), (1, 3))
        .map(toTuple) shouldBe Array((1, 5), (6, 7), (8, 10), (12, 16))
      InsertInterval57.insert(Array((3, 5), (6, 7), (8, 10), (12, 16)), (1, 6))
        .map(toTuple) shouldBe Array((1, 7), (8, 10), (12, 16))
    }
    "insert a new interval at end" in {
      InsertInterval57.insert(Array((3, 5), (6, 7), (8, 10), (12, 16)), (17, 20))
        .map(toTuple) shouldBe Array((3, 5), (6, 7), (8, 10), (12, 16), (17, 20))
      InsertInterval57.insert(Array((3, 5), (6, 7), (8, 10), (12, 16)), (11, 20))
        .map(toTuple) shouldBe Array((3, 5), (6, 7), (8, 10), (11, 20))
    }
  }
}