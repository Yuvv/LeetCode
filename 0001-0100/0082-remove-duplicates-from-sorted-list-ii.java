
/*
 * 0082-remove-duplicates-from-sorted-list-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2020/11/21
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return head;
        }
        ListNode lastDistinct = null;
        ListNode last = null;
        ListNode cur = head;
        while (cur != null) {
            last = cur;
            cur = cur.next;
            boolean hasDup = false;
            // 若有重复，则遍历，走到下一个不重复的值
            while (cur != null && cur.val == last.val) {
                hasDup = true;
                last = cur;
                cur = cur.next;
            }
            if (hasDup) {
                if (cur == null) {
                    // 如果是因为 null 退出，则后缀部分全部为相同值
                    if (lastDistinct != null) {
                        lastDistinct.next = null;
                    }
                } else {
                    // 如果是因为不相等退出，挂到下一个不相同值的节点，重复循环
                    if (lastDistinct != null) {
                        lastDistinct.next = cur;
                    }
                    last = null;
                }
            } else {
                if (lastDistinct == null) {
                    // 找到第一个
                    lastDistinct = last;
                    head = last;
                } else {
                    // 直接挂到下一个节点
                    lastDistinct.next = last;
                    lastDistinct = last;
                }
            }
        }
        if (lastDistinct == null) {
            // 如果没找到唯一值
            return null;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode head = null;
        // case1: null -> null
        printListNode(s.deleteDuplicates(head));

        // case2: 1,1,1 -> null
        head = new ListNode(1, new ListNode(1, new ListNode(1, null)));
        printListNode(s.deleteDuplicates(head));

        // case3: 1,1,2,2 -> null
        head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, null))));
        printListNode(s.deleteDuplicates(head));

        // case4: 1,1,2 -> 2
        head = new ListNode(1, new ListNode(1, new ListNode(2, null)));
        printListNode(s.deleteDuplicates(head));

        // case5: 1,1,2,3,3 -> 2
        head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, null)))));
        printListNode(s.deleteDuplicates(head));

        // case6: 1,1,2,3,3,4 -> 2,4
        head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, null))))));
        printListNode(s.deleteDuplicates(head));
    }

    public static void printListNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }
}