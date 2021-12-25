import java.util.Set;
import java.util.HashSet;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        int count = 0;
        while (head != null) {
            if (set.contains(head.val)) {
                count++;
                while (head != null && set.contains(head.val)) {
                    head = head.next;
                }
            }
            if (head != null) {
                head = head.next;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.numComponents(
            new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3)))),
            new int[] {0,1,3}
        ));
        // 2
        System.out.println(s.numComponents(
            new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))),
            new int[] {0,3,1,4}
        ));
    }
}