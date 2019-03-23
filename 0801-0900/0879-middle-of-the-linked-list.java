/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 找出单链表的中间节点
     * https://leetcode.com/problems/middle-of-the-linked-list/
     *
     * @param head 头指针
     * @return 中间节点
     */
    public ListNode middleNode(ListNode head) {
        ListNode one = head, two = head;
        while (one.next != null) {
            if (two.next == null) {
                return one;
            }
            if (two.next.next == null) {
                return one.next;
            }
            one = one.next;
            two = two.next.next;
        }
        return one;
    }
}