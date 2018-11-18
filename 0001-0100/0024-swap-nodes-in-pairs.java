/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        int tmp;
        while (cur != null && cur.next != null) {
            tmp = cur.next.val;
            cur.next.val = cur.val;
            cur.val = tmp;
            cur = cur.next.next;
        }
        return head;
    }
}