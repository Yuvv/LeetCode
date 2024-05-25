import java.util.*;

/**
 * 2487-remove-nodes-from-linked-list.java
 *
 * @date 2024/5/25
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public ListNode removeNodes(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<>();
        while (head != null) {
            while (!stack.isEmpty() && stack.peek().val < head.val) {
                stack.pop();
            }
            stack.push(head);
            head = head.next;
        }
        head = null;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            node.next = head;
            head = node;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [13,8]
        System.out.println(s.removeNodes(
                new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8)))))));
        // [1,1,1,1,1]
        System.out.println(s.removeNodes(
                new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1)))))));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        if (next == null) {
            return val + "";
        }
        return val + " -> " + next.toString();
    }
}
