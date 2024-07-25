import java.util.*;

/**
 * 3217-delete-nodes-from-linked-list-present-in-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/25
 */
public class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        while (head != null && set.contains(head.val)) {
            head = head.next;
        }
        if (head != null) {
            ListNode node = head;
            while (node.next != null) {
                if (set.contains(node.next.val)) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [4,5]
        System.out.println(s.modifiedList(
            new int[] {1,2,3},
            new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))
        ));
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
        return val + "->" + next;
    }
}
