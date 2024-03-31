package contest.leetcode.dp

/**
 * https://leetcode.com/problems/01-matrix/
 *
 * @author Dmitry Openkov
 */
object Matrix542 {
  def updateMatrix(mat: Array[Array[Int]]): Array[Array[Int]] = {
    val distances = mat.map(row => row.map {
      case 0 => 0
      case _ => Int.MaxValue / 2
    })

    def goThroughRow(row: Array[Int], direct: Boolean): Unit = {
      var prev = Int.MaxValue / 2
      for (x <- if (direct) row.indices else row.indices.reverse) {
        if (row(x) > prev + 1) {
          row(x) = prev + 1
        }
        prev = row(x)
      }
    }

    def goThroughColumn(matrix: Array[Array[Int]], col: Int, direct: Boolean): Unit = {
      var prev = Int.MaxValue / 2
      for (y <- if (direct) matrix.indices else matrix.indices.reverse) {
        if (matrix(y)(col) > prev + 1) {
          matrix(y)(col) = prev + 1
        }
        prev = matrix(y)(col)
      }
    }

    for (y <- distances.indices) {
      val row = distances(y)
      goThroughRow(row, direct = true)
      goThroughRow(row, direct = false)
    }
    for (x <- distances.head.indices) {
      goThroughColumn(distances, x, direct = true)
      goThroughColumn(distances, x, direct = false)
    }
    distances
  }
}
