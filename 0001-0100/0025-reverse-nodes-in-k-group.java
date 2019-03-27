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
     * 翻转链表（每隔 k 个）
     * https://leetcode.com/problems/reverse-nodes-in-k-group/
     *
     * @param head 链表头
     * @param k    每隔 k 个
     * @return 新 list
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode lastHead = result;
        ListNode nextHead, tempNode;
        int count;
        while (head != null) {
            // 先找到下一个头部，找不到就返回（当前部分链表长度小于 k 时返回）
            count = 0;
            nextHead = lastHead;
            while (nextHead != null && count <= k) {
                nextHead = nextHead.next;
                count++;
            }
            if (count <= k) {
                break;
            }
            // 找到下一个头部，就开始逆序这一段链表
            count = 0;
            while (head != null && count < k) {
                tempNode = head.next;
                // 是当前链表头部时，将头部指向下一个头部；否则逆序添加
                if (lastHead.next != head) {
                    head.next = lastHead.next;
                } else {
                    head.next = nextHead;
                    nextHead = head;
                }
                lastHead.next = head;
                head = tempNode;
                count++;
            }
            lastHead = nextHead;
        }
        return result.next;
    }
}