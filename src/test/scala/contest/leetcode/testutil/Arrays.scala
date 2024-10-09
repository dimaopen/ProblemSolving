package contest.leetcode.testutil

import scala.language.implicitConversions
import scala.reflect.ClassTag

/**
 * @author Dmitry Openkov
 */
object Arrays:
  def toTuple2[T](array: Array[T]): (T, T) = (array(0), array(1))

  implicit def toArray[T: ClassTag](t: (T, T)): Array[T] = t.productIterator.asInstanceOf[Iterator[T]].toArray

  def makeMatrix(matrix: String): Array[Array[Int]] = makeMatrix(matrix)(_.toInt)

  def makeMatrix[T: ClassTag](matrix: String)(mapper: (x: String) => T): Array[Array[T]] =
    matrix.split('\n').map(_.trim).filter(_.nonEmpty).map(_.split(' ').map(mapper))


