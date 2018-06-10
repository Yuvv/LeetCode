/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        ListNode cur1 = l1, cur2 = l2;
        
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                cur.next = new ListNode(cur1.val);
                cur = cur.next;
                cur1 = cur1.next;
            } else {
                cur.next = new ListNode(cur2.val);
                cur = cur.next;
                cur2 = cur2.next;
            }
        }
        
        while (cur1 != null) {
            cur.next = new ListNode(cur1.val);
            cur = cur.next;
            cur1 = cur1.next;
        }
        
        while (cur2 != null) {
            cur.next = new ListNode(cur2.val);
            cur = cur.next;
            cur2 = cur2.next;
        }
        
        return head.next;
    }
}