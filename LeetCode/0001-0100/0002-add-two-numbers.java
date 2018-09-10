/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        int carry = sum / 10;
        sum %= 10;
        ListNode head = new ListNode(sum);
        ListNode cur = head;
        l1 = l1.next;
        l2 = l2.next;
        
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            sum = l1.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            l1 = l1.next;
        }
        
         while (l2 != null) {
            sum = l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            l2 = l2.next;
        }
        
        // 最后一个 carry 可能不为 0
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        
        return head;
    }
}