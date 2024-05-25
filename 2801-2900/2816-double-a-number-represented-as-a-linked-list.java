import java.util.LinkedList;

/**
 * 2816-double-a-number-represented-as-a-linked-list.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/05/25
 */
public class Solution {
    public ListNode doubleIt(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int carry = 0;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            node.val = node.val * 2 + carry;
            if (node.val >= 10) {
                node.val -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            node.next = head;
            head = node;
        }
        if (carry > 0) {
            ListNode node = new ListNode(1);
            node.next = head;
            head = node;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [3,7,8]
        System.out.println(s.doubleIt(new ListNode(1, new ListNode(8, new ListNode(9)))));
        // [1,9,9,8]
        System.out.println(s.doubleIt(new ListNode(9, new ListNode(9, new ListNode(9)))));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    @Override
    public String toString() {
        if (next == null) {
            return val + "";
        }
        return val + " -> " + next.toString();
    }
}
