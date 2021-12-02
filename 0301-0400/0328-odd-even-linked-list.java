import java.util.*;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/*
 * 0328-odd-even-linked-list.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/02
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(1);
        ListNode oddTail = oddHead;
        ListNode evenHead = new ListNode(0);
        ListNode evenTail = evenHead;
        int i = 0;
        while (head != null) {
            if (i % 2 == 0) {
                evenTail.next = head;
                head = head.next;
                evenTail = evenTail.next;
                evenTail.next = null;
            } else {
                oddTail.next = head;
                head = head.next;
                oddTail = oddTail.next;
                oddTail.next = null;
            }
            i++;
        }
        evenTail.next = oddHead.next;
        return evenHead.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,3,5,2,4]
        System.out.println(s.oddEvenList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
    }
}