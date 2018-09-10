/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return head;
        }
        ListNode last = head;
        ListNode cur = head.next;
        while (null != cur) {
            if (cur.val == last.val) {
                last.next = cur.next;
            } else {
                last = cur;
            }
            cur = cur.next;
        }
        
        return head;
    }
}