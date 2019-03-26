/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 合并排序链表
     * https://leetcode.com/problems/merge-k-sorted-lists/
     *
     * @param lists 链表列表
     * @return 排列后的链表
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int minIndex = findMinIndex(lists, Integer.MIN_VALUE);
        if (minIndex < 0) {
            return null;
        }
        ListNode head = lists[minIndex];
        ListNode pos = head;
        int lastMin = head.val;
        lists[minIndex] = lists[minIndex].next;
        while (minIndex >= 0) {
            minIndex = findMinIndex(lists, lastMin);
            if (minIndex < 0) {
                break;
            }
            pos.next = lists[minIndex];
            pos = pos.next;
            lastMin = lists[minIndex].val;
            lists[minIndex] = lists[minIndex].next;
        }

        return head;
    }

    private int findMinIndex(ListNode[] lists, int lastMin) {
        int curMin = Integer.MAX_VALUE;
        int curMinIndex = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                if (lists[i].val == lastMin) {
                    return i;
                }
                if (lists[i].val < curMin) {
                    curMin = lists[i].val;
                    curMinIndex = i;
                }
            }
        }
        return curMinIndex;
    }
}