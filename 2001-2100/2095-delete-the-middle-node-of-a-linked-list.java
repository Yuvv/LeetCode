
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return val + " -> " + next;
    }
}

/*
 * 2095-delete-the-middle-node-of-a-linked-list.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/07
 */
public class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode slowPre = null;
        while (slow != null && fast != null && fast.next != null) {
            slowPre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slowPre != null && slow != null) {
            slowPre.next = slow.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,3,4,1,2,6]
        System.out.println(s.deleteMiddle(new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(7, new ListNode(1, new ListNode(2, new ListNode(6)))))))));
        // [1,2,4]
        System.out.println(s.deleteMiddle(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));
        // [1,3]
        System.out.println(s.deleteMiddle(new ListNode(1, new ListNode(2, new ListNode(3)))));
        // [1]
        System.out.println(s.deleteMiddle(new ListNode(1, new ListNode(2))));
        // []
        System.out.println(s.deleteMiddle(new ListNode(1)));
    }
}