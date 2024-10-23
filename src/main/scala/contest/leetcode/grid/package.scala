package contest.leetcode

/**
 * @author Dmitry Openkov
 */
package object grid {
  abstract case class Cell[A](x: Int, y: Int):
    def value: A
    def filteredNeighbors(pred: Cell[A] => Boolean): Seq[Cell[A]]
    def setValue(a: A): Unit

  object Cell:
    def gridCell[A](xPos: Int, yPos: Int)(implicit grid: Array[Array[A]]): Cell[A] =
      new Cell[A](xPos, yPos):
        override def value: A = grid(this.x)(this.y)
        override def setValue(a: A):Unit =
          grid(x)(y) = a

        override def filteredNeighbors(pred: Cell[A] => Boolean): Seq[Cell[A]] =
          Seq(gridCell(x - 1, y), gridCell(x, y - 1), gridCell(x + 1, y), gridCell(x, y + 1))
            .filter { case neigh@Cell(x, y) => x >= 0 && y >= 0 && x < grid.length && y < grid.head.length
              && pred(neigh)
            }

    def findCells[A](pred: Cell[A] => Boolean)(implicit grid: Array[Array[A]]): Seq[Cell[A]] =
      for {
        x <- grid.indices
        y <- grid.head.indices
        cell = gridCell(x, y) if pred(cell)
      } yield cell

  end Cell


}
