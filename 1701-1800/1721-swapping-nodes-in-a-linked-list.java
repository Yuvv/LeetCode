class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/*
 * 1721-swapping-nodes-in-a-linked-list.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/22
 */
public class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int cnt = 0;
        ListNode kNode = null, rkNode = null;
        ListNode cursor = head;
        while (cursor != null) {
            cnt++;
            if (cnt == k) {
                kNode = cursor;
            }
            cursor = cursor.next;
        }
        cursor = head;
        int rk = cnt - k + 1;
        cnt = 0;
        while (cursor != null) {
            cnt++;
            if (cnt == rk) {
                rkNode = cursor;
                break;
            }
            cursor = cursor.next;
        }
        int tmp = kNode.val;
        kNode.val = rkNode.val;
        rkNode.val = tmp;
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,4,3,2,5]
        System.out.println(s.swapNodes(
            new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),
            2
        ));
        // [7,9,6,6,8,7,3,0,9,5]
        System.out.println(s.swapNodes(
            new ListNode(7, new ListNode(9, new ListNode(6, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(3, new ListNode(0, new ListNode(9, new ListNode(5)))))))))),
            5
        ));

    }
}