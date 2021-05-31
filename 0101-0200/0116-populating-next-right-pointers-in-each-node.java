/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
public class Solution {
    /**
     * 二叉树横向链表
     * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
     *
     * 其实也就是二叉树的层级遍历，用队列即可。（注意空指针问题）
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        LinkedList<Node> list = new LinkedList<>();
        list.add(null);

        Node curNode = root;
        Node nextNode;

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
                return root;
            }
        }
        return root;
    }
}