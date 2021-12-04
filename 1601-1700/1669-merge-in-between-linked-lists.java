
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


/*
 * 1669-merge-in-between-linked-lists.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/04
 */
public class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // 1 <= a <= b < list1.length - 1
        ListNode cur = list1;
        ListNode tail = cur;
        int i = 0;
        while (i < a) {
            tail = cur;
            cur = cur.next;
            i++;
        }
        tail.next = list2;

        while (i < b) {
            cur = cur.next;
            i++;
        }
        tail = cur.next;

        // find list2.tail
        cur = list2;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = tail;
        return list1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [0,1,2,1000000,1000001,1000002,5]
        System.out.println(s.mergeInBetween(
            new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))),
            3,
            4,
            new ListNode(1000000, new ListNode(1000001, new ListNode(1000002)))
        ));
    }
}