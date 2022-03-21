/*
 * 2181-merge-nodes-in-between-zeros.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/21
 */
public class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode ret = new ListNode(0);
        ListNode cur = ret;

        head = head.next;
        while (head != null) {
            while (head != null && head.val > 0) {
                cur.val += head.val;
                head = head.next;
            }
            if (head != null && head.next != null) {
                cur.next = new ListNode(0);
                cur = cur.next;
            }
            head = head.next;
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [4,11]
        System.out.println(s.mergeNodes(
            new ListNode(0, new ListNode(3, new ListNode(1, new ListNode(0, new ListNode(4, new ListNode(5, new ListNode(2, new ListNode(0))))))))
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
        return val + "->" + next;
    }
}
