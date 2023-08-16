package contest.leetcode

/**
 * @author Dmitry Openkov
 */
object UniquePaths6263 {
  def uniquePaths1(m: Int, n: Int): Int = {
    val field = Array.fill(m, n)(1)
    for (y <- 1 until m; x <- 1 until n)
      field(y)(x) = field(y - 1)(x) + field(y)(x - 1)
    field(m - 1)(n - 1)
  }

  def uniquePaths(m: Int, n: Int): Int = {
    (0 until n - 1).foldLeft(List.fill(m)(1))(
      (acc, _) => acc.scanLeft(0)(_ + _).tail
    ).last
  }

  def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = {
    //invert incoming grid
    obstacleGrid.foreach(row => row.zipWithIndex.foreach { case (value, i) => row(i) = if (value == 0) 1 else 0 })
    //fill with zeros the unpassable squares of the first row
    val firstRow = obstacleGrid(0)
    firstRow.zipWithIndex.tail.foreach { case (value, i) => firstRow(i) = if (value == 0) 0 else firstRow(i - 1) }
    //fill with zeros the unpassable squares of the first column
    obstacleGrid.zipWithIndex.tail.foreach { case (row, i) => row(0) = if (row(0) == 0) 0 else obstacleGrid(i - 1)(0)}
    //calculate num ways
    val m = obstacleGrid.length
    val n = obstacleGrid.head.length
    for (y <- 1 until m; x <- 1 until n)
      obstacleGrid(y)(x) = if (obstacleGrid(y)(x) == 0) 0 else obstacleGrid(y - 1)(x) + obstacleGrid(y)(x - 1)
    obstacleGrid(m - 1)(n - 1)
  }


  def main(args: Array[String]): Unit = {
    println(uniquePathsWithObstacles(Array(Array(0, 0, 0))))
    println(uniquePathsWithObstacles(Array(Array(0, 1, 0))))
    println(uniquePathsWithObstacles(Array(Array(0, 1))))
    println(uniquePathsWithObstacles(Array(Array(1, 0))))
    println(uniquePathsWithObstacles(Array(Array(0), Array(1), Array(0))))
    println(uniquePathsWithObstacles(Array(Array(0), Array(0), Array(0))))
    println(uniquePathsWithObstacles(Array(Array(0, 1), Array(0, 0))))
    println(uniquePathsWithObstacles(Array(Array(0, 0, 0), Array(0, 1, 0), Array(0, 0, 0))))
    println(uniquePathsWithObstacles(Array(Array(0, 0, 0, 0), Array(0, 1, 0, 0), Array(0, 0, 0, 0))))
//    println(uniquePaths(3, 7))
//    println(uniquePaths(3, 2))
//    println(uniquePaths(10, 10))
//    println(uniquePaths(19, 19))
  }
}
