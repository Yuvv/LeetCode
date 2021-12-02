
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/*
 * 0725-split-linked-list-in-parts.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/02
 */
public class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        // 1. count
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        // 2. get each park count
        int partCnt = count / k;
        int remainCnt = count % k;
        // 3. build result
        ListNode[] res = new ListNode[k];
        cur = head;
        int idx = 0;
        while (cur != null) {
            ListNode tail = res[idx];
            int end = partCnt;
            if (remainCnt > 0) {
                end++;
                remainCnt--;
            }
            for (int i = 0; cur != null && i < end; i++) {
                if (tail == null) {
                    res[idx] = cur;
                    tail = cur;
                } else {
                    tail.next = cur;
                    tail = tail.next;
                }
                cur = cur.next;
            }
            tail.next = null;
            idx++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[1],[2],[3],[],[]]
        System.out.println(s.splitListToParts(new ListNode(1, new ListNode(2, new ListNode(3))), 5));
    }
}