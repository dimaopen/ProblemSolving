package contest.leetcode.testutil

import scala.language.implicitConversions
import scala.reflect.ClassTag

/**
 * @author Dmitry Openkov
 */
object Arrays {
  def toTuple2[T](array: Array[T]): (T, T) = (array(0), array(1))

  implicit def toArray[T: ClassTag](t: (T, T)): Array[T] = t.productIterator.asInstanceOf[Iterator[T]].toArray

}
