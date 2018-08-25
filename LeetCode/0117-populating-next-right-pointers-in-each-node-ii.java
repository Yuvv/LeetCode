/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * 二叉树横向链表
     * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
     *
     * 其实也就是二叉树的层级遍历，用队列即可。（注意空指针问题）
     */
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeLinkNode> list = new LinkedList<>();
        list.add(null);

        TreeLinkNode curNode = root;
        TreeLinkNode nextNode;

        while(!list.isEmpty()) {
            nextNode = list.pollFirst();
            curNode.next = nextNode;
            if (curNode.left != null) {
                list.addLast(curNode.left);
            }
            if (curNode.right != null) {
                list.addLast(curNode.right);
            }
            if (!list.isEmpty()) {
                if (nextNode == null) {
                    list.addLast(null);
                    curNode = list.pollFirst();
                } else {
                    curNode = nextNode;
                }
            } else {
                return;
            }
        }
    }
}