package contest.leetcode.graph

import contest.leetcode.grid.Cell

import scala.annotation.tailrec

/**
 * @author Dmitry Openkov
 */
object RottingOranges994:
  def orangesRotting(implicit grid: Array[Array[Int]]): Int =
    @tailrec
    def _go(minute: Int, front: Seq[Cell[Int]]): Int =
      val fresh = front.flatMap(cell => cell.filteredNeighbors(c => c.value == 1))
      if fresh.isEmpty then
        minute
      else
        fresh.foreach(_.setValue(2))
        _go(minute + 1, fresh)


    val minutesToFinish = _go(0, Cell.findCells[Int](cell => cell.value == 2))
    val numFresh = Cell.findCells[Int](cell => cell.value == 1).size
    if numFresh > 0 then -1 else minutesToFinish


end RottingOranges994

