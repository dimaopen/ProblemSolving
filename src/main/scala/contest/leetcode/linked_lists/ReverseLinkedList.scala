package contest.leetcode.linked_lists

import scala.annotation.tailrec

/**
 * Definition for singly-linked list.
 *
 * }
 */
object ReverseLinkedList {
  def reverseList(head: ListNode): ListNode = {
    var directPrev: ListNode = null
    var node = head
    while (node != null) {
      val directNext = node.next
      node.next = directPrev
      directPrev = node
      node = directNext
    }
    directPrev
  }

  @tailrec
  def reverseRec(head: ListNode, directPrev: ListNode = null): ListNode = {
    if (head == null)
      directPrev
    else {
      val directNext = head.next
      head.next = directPrev
      reverseRec(directNext, head)
    }
  }

  def main(args: Array[String]): Unit = {
    println(reverseList(new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, null))))))
    println(reverseList(new ListNode(1)))
    println(reverseList(null))
    println(reverseRec(new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, null))))))
    println(reverseRec(new ListNode(1)))
    println(reverseRec(null))
  }

}