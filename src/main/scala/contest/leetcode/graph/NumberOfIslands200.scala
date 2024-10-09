package contest.leetcode.graph

/**
 * @author Dmitry Openkov
 */
object NumberOfIslands200:


  def numIslands(grid: Array[Array[Char]]): Int =
    case class Cell(x: Int, y: Int):
      def notVisitedNeighbours: Seq[Cell] =
        Seq(Cell(x - 1, y), Cell(x, y - 1), Cell(x + 1, y), Cell(x, y + 1))
          .filter { case neigh@Cell(x, y) => x >= 0 && y >= 0 && x < grid.length && y < grid.head.length
            && neigh.value == '1'
          }

      def value: Char =
        grid(x)(y)

      def setValue(value: Char): Unit =
        grid(x)(y) = value

    end Cell

    var islandNum = 0

    def dfs(cell: Cell): Unit =
      for (
        neigh <- cell.notVisitedNeighbours
      ) {
        neigh.setValue('2')
        dfs(neigh)
      }

    for {
      x <- grid.indices
      y <- grid.head.indices
    }
      val cell = Cell(x, y)
      if cell.value == '1' then
        islandNum += 1
        dfs(cell)
    islandNum

end NumberOfIslands200

