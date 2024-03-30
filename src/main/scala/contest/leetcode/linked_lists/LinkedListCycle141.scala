package contest.leetcode.linked_lists

/**
 * @author Dmitry Openkov
 */
object LinkedListCycle141 {
  def hasCycle(head: ListNode): Boolean = {
    var slow, fast = head
    while (true) {
      slow = move(slow, 1)
      fast = move(fast, 2)
      if (slow == null || fast == null)
        return false
      if (slow == fast)
        return true
    }
    false
  }

  def move (node: ListNode, n: Int): ListNode = {
    var result: ListNode = node
    (1 to n) foreach {_ =>
      if (result == null)
        return null
      result = result.next
    }
    result
  }

  def main(args: Array[String]): Unit = {
    println(hasCycle(new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, null))))))
    val cycled = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, null))))
    cycled.next.next.next.next = cycled
    println(hasCycle(cycled))
    val cycled2 = new ListNode(-1, cycled)
    println(hasCycle(cycled2))
  }

}
