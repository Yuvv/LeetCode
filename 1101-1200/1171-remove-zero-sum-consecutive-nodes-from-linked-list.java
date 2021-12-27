import java.util.*;


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

/*
 * 1171-remove-zero-sum-consecutive-nodes-from-linked-list.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/27
 */
public class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> cumsumMap = new HashMap<>();
        int cumsum = 0;
        cumsumMap.put(0, null);
        ListNode cursor = head;
        while (cursor != null) {
            cumsum += cursor.val;
            if (cumsumMap.containsKey(cumsum)) {
                ListNode prevNode = cumsumMap.get(cumsum);
                ListNode toDeleteHead;
                if (prevNode == null) {
                    toDeleteHead = head;
                    head = cursor.next;
                } else {
                    toDeleteHead = prevNode.next;
                    prevNode.next = cursor.next;
                }
                // delete node in sequences
                int newSum = cumsum;
                while (toDeleteHead != null) {
                    newSum += toDeleteHead.val;
                    if (newSum == cumsum) {
                        break;
                    }
                    cumsumMap.remove(newSum);
                    toDeleteHead = toDeleteHead.next;
                }
            } else {
                cumsumMap.put(cumsum, cursor);
            }
            cursor = cursor.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,5,1]
        System.out.println(s.removeZeroSumSublists(
                new ListNode(1, new ListNode(3, new ListNode(2, new ListNode(-3, new ListNode(-2, new ListNode(5, new ListNode(5, new ListNode(-5, new ListNode(1)))))))))
        ));
        // [3,1]
        System.out.println(s.removeZeroSumSublists(
            new ListNode(1, new ListNode(2, new ListNode(-3, new ListNode(3, new ListNode(1)))))
        ));
        // [1,2,4]
        System.out.println(s.removeZeroSumSublists(
            new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(-3, new ListNode(4)))))
        ));
        // [1]
        System.out.println(s.removeZeroSumSublists(
            new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(-3, new ListNode(-2)))))
        ));
    }
}