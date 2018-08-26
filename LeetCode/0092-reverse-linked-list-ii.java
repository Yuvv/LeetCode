/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    /**
     * 部分反转链表
     * https://leetcode.com/problems/reverse-linked-list-ii/description/
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode mPrevNode = null;
        ListNode mNode;
        ListNode mnHead, mnHeadNext = null;

        int count = 1;
        ListNode cursor = head;
        while (count < m) {
            mPrevNode = cursor;
            cursor = cursor.next;
            count++;
        }
        mNode = cursor;

        // 新创建一个 head 反转 m-n 部分链表
        mnHead = new ListNode(-1);
        do {
            mnHead.next = cursor;
            cursor = cursor.next;
            mnHead.next.next = mnHeadNext;
            mnHeadNext = mnHead.next;
            count++;
        } while (count <= n);

        if (mPrevNode != null) {
            mPrevNode.next = mnHead.next;
        } else {
            head = mnHeadNext;
        }
        mNode.next = cursor;

        return head;
    }
}