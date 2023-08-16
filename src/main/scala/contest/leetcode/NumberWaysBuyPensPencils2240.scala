package contest.leetcode

/**
 * @author Dmitry Openkov
 */
object NumberWaysBuyPensPencils2240 {
  def waysToBuyPensPencils(total: Int, cost1: Int, cost2: Int): Long = {
    val maxNumPens = total / cost1
    val numPencilsSeq = for (numPens <- 0 to maxNumPens) yield (total - cost1 * numPens) / cost2 + 1L
    numPencilsSeq.sum
  }
}
