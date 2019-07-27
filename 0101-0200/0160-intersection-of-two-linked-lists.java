/*
 * 0160-intersection-of-two-linked-lists.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2019/07/27
 */


/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
   }
}

public class Solution {
    /**
     * 求两个链表的交点。
     * 解：遍历两个链表，当一个遍历到终点时换到另一个，这样如果两个人有交点则一定会相遇（遍历长度相等）
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA;
        ListNode pb = headB;
        int aTraveTime = 0;
        int bTraveTime = 0;
        while (aTraveTime < 2 && bTraveTime < 2 && !pa.equals(pb)) {
            pa = pa.next;
            pb = pb.next;
            if (pa == null) {
                aTraveTime += 1;
                pa = headB;
            }
            if (pb == null) {
                bTraveTime += 1;
                pb = headA;
            }
        }
        if (pa.equals(pb)) {
            return pa;
        }
        return null;
    }
}