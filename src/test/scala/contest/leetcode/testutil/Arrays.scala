package contest.leetcode.testutil

import scala.language.implicitConversions
import scala.reflect.ClassTag

/**
 * @author Dmitry Openkov
 */
object Arrays {
  def toTuple2[T](array: Array[T]): (T, T) = (array(0), array(1))

  implicit def toArray2[T: ClassTag](t: (T, T)): Array[T] = Array(t._1, t._2)

}
