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
     * 反转链表
     * https://leetcode.com/problems/reverse-linked-list-ii/description/
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode rHead = new ListNode(-1);
        rHead.next = head;
        ListNode rHeadNext = head;
        head = head.next;
        rHead.next.next = null;
        while (head != null) {
            rHead.next = head;
            head = head.next;
            rHead.next.next = rHeadNext;
            rHeadNext = rHead.next;
        }
        return rHead.next;
    }
}