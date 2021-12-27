
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    static ListNode fromArray(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cursor = head;
        for (int i = 1; i < arr.length; i++) {
            cursor.next = new ListNode(arr[i]);
            cursor = cursor.next;
        }
        return head;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/*
 * 1367-linked-list-in-binary-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/28
 */
public class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return isSubPath(head, root, true);
    }

    public boolean isSubPath(ListNode head, TreeNode root, boolean isRealHead) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        boolean ok = false;
        if (head.val == root.val) {
            // try left
            ok = isSubPath(head.next, root.left, false);
            if (!ok) {
                // try right
                ok = isSubPath(head.next, root.right, false);
            }
        }

        if (!ok && isRealHead) {
            // try left tree from head
            ok = isSubPath(head, root.left, isRealHead);
            if (!ok) {
                // try right tree from head
                ok = isSubPath(head, root.right, isRealHead);
            }
        }
        return ok;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isSubPath(
            ListNode.fromArray(new int[] {4,2,8}),
            new TreeNode(
                1,
                new TreeNode(4, null, new TreeNode(2, new TreeNode(1), null)),
                new TreeNode(4, new TreeNode(2, new TreeNode(6), new TreeNode(8, new TreeNode(1), new TreeNode(3))), null)
            )
        ));
    }
}