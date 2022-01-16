import java.util.*;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/*
 * 2130-maximum-twin-sum-of-a-linked-list.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/16
 */
public class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // even length
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode nextHalfHead = slow;
        ListNode tmpHead = new ListNode(0);
        // reverse next half
        while (nextHalfHead != null) {
            ListNode next = nextHalfHead.next;
            nextHalfHead.next = tmpHead.next;
            tmpHead.next = nextHalfHead;
            nextHalfHead = next;
        }
        // calculate max sum
        int maxsum = 0;
        fast = tmpHead.next;
        slow = head;
        while (fast != null) {
            maxsum = Math.max(maxsum, slow.val + fast.val);
            slow = slow.next;
            fast = fast.next;
        }
        return maxsum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.pairSum(new ListNode(5, new ListNode(4, new ListNode(2, new ListNode(1))))));
        // 7
        System.out.println(s.pairSum(new ListNode(4, new ListNode(2, new ListNode(2, new ListNode(3))))));
    }
}