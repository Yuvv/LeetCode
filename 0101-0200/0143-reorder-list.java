import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/*
 * 0143-reorder-list.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2020/12/20
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode cur1 = head;
        ListNode cur2 = head;
        while (cur2 != null && cur2.next != null) {
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        }
        // now reverse post half list
        ListNode tailCur = null;
        while (cur1.next != null) {
            ListNode nextNode = cur1.next;
            cur1.next = cur1.next.next;
            nextNode.next = tailCur;
            tailCur = nextNode;
        }
        // concat two list
        cur1 = head;
        while (tailCur != null) {
            ListNode tailCurNext = tailCur.next;
            ListNode cur1Next = cur1.next;
            cur1.next = tailCur;
            tailCur.next = cur1Next;
            // go to next node
            cur1 = cur1Next;
            tailCur = tailCurNext;
        }
        // return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // 1->2->3->4  --- 1->4->2->3
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        s.reorderList(l1);
        printList(l1);
        // 1->2->3->4->5  --- 1->5->2->4->3
        ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        s.reorderList(l2);
        printList(l2);
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            System.out.print("->");
            head = head.next;
        }
        System.out.println();
    }
}