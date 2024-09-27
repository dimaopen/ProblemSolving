package contest.leetcode.linked_lists

/**
 * @author Dmitry Openkov
 */
class MinStack155:
  class Node(val x: Int, val min: Int, val next: Node)
  private var head = Node(0, Int.MaxValue, null)

  def push(x: Int): Unit = 
    head = Node(x, math.min(x, head.min), head)

  def pop(): Unit = 
    head = head.next

  def top(): Int = head.x

  def getMin(): Int = head.min

end MinStack155

/**
 * Your MinStack object will be instantiated and called as such:
 * val obj = new MinStack()
 * obj.push(`val`)
 * obj.pop()
 * val param_3 = obj.top()
 * val param_4 = obj.getMin()
 */
