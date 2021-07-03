import java.util.List;
import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/*
 * 0445-add-two-numbers-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/07/03
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();
        while (l1 != null) {
            q1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            q2.push(l2.val);
            l2 = l2.next;
        }

        ListNode head = new ListNode(0);
        int carry = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int curVal = q1.pop() + q2.pop() + carry;
            carry = curVal / 10;
            curVal = curVal % 10;
            // insert front
            ListNode curNode = new ListNode(curVal, head.next);
            head.next = curNode;
        }
        // make q1 as not empty one
        if (q1.isEmpty() && !q2.isEmpty()) {
            q1 = q2;
        }
        // add others in q1
        while (!q1.isEmpty()) {
            int curVal = q1.pop() + carry;
            carry = curVal / 10;
            curVal = curVal % 10;
            // insert front
            ListNode curNode = new ListNode(curVal, head.next);
            head.next = curNode;
        }
        // add carry is exists
        if (carry > 0) {
            // insert front
            ListNode curNode = new ListNode(carry, head.next);
            head.next = curNode;
        }
        return head.next;
    }
}