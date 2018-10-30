/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode nHead = new ListNode(0);
        nHead.next = head;
        ListNode last = nHead,
                 cur = head;
        while (cur != null) {
            if (cur.val == val) {
                last.next = cur.next;
            } else {
                last = last.next;
            }
            cur = cur.next;
        }
        return nHead.next;
    }
}