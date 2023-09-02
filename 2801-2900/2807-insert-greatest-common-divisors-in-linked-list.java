import java.util.*;
/*
 * 2807-insert-greatest-common-divisors-in-linked-list.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/09/02
 */
public class Solution {

    public int gcd(int a, int b) {
        // let `a` large than `b`
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (a % b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return b;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode prev = head;
        ListNode it = head.next;
        while (it != null) {
            int res = gcd(prev.val, it.val);
            prev.next = new ListNode(res, it);
            prev = it;
            it = it.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [18,6,6,2,10,1,3]
        System.out.println(s.insertGreatestCommonDivisors(
            new ListNode(18, new ListNode(6, new ListNode(10, new ListNode(3))))
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
        StringBuilder sb = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            sb.append(node.val);
            if (node.next != null) {
                sb.append(" -> ");
            }
            node = node.next;
        }
        return sb.toString();
    }
}
