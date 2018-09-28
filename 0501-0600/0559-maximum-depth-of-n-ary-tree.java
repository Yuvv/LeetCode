/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    int maxDepthResult;
    /**
     * 求 n 叉树的深度
     * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/description/
     */
    public int maxDepth(Node root) {
        maxDepthResult = 0;
        walk(root, 1);
        return maxDepth;
    }

    void walk(Node root, int curDepth) {
        if (root == null) {
            return;
        }
        if (maxDepthResult < curDepth) {
            maxDepthResult = curDepth;
        }
        for (Node node: root.children) {
            walk(node, curDepth + 1);
        }
    }
}