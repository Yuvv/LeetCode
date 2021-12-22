import java.util.LinkedList;

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

public class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int groupSize = 1;
        int groupCount = 1;
        LinkedList<Integer> stack = new LinkedList<>();
        ListNode groupHead;
        ListNode cursor = head.next;
        while (cursor != null) {
            groupSize++;
            groupCount++;
            stack.clear();
            int count = 0;
            groupHead = cursor;
            while (cursor != null && count < groupSize) {
                count++;
                stack.push(cursor.val);
                cursor = cursor.next;
            }
            if (count % 2 == 0) {
                // set value
                cursor = groupHead;
                while (cursor != null && count > 0) {
                    count--;
                    cursor.val = stack.pop();
                    cursor = cursor.next;
                }
            }
        }
        return head;
    }

    public ListNode buildList(int... nums) {
        ListNode head = new ListNode(0);
        ListNode cursor = head;
        for (int num : nums) {
            cursor.next = new ListNode(num);
            cursor = cursor.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [5,6,2,3,9,1,4,8,3,7]
        System.out.println(s.reverseEvenLengthGroups(
            s.buildList(5,2,6,3,9,1,7,3,8,4)
        ));
        // [1,0,1,6]
        System.out.println(s.reverseEvenLengthGroups(
            s.buildList(1,1,0,6)
        ));
        // [1,0,1,5,6]
        System.out.println(s.reverseEvenLengthGroups(
            s.buildList(1,1,0,6,5)
        ));
        // [0,4,3,1,5,2]
        System.out.println(s.reverseEvenLengthGroups(
            s.buildList(0,3,4,1,5,2)
        ));
    }
}