/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

 // 从链表中移除倒数第 n 个元素
 func removeNthFromEnd(head *ListNode, n int) *ListNode {
    listLen := 0
    cur := head
    for cur != nil {
        listLen++
        cur = cur.Next
    }
    listLen -= n + 1
    if listLen < 0 {
        return head.Next
    }
    cur = head
    for listLen > 0 {
        listLen--
        cur = cur.Next
    }
    cur.Next = cur.Next.Next

    return head
}