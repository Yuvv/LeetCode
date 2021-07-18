import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Definition for a Node.
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


public class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            resultList.add(node.val);
            if (node.children != null && !node.children.isEmpty()) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,3,5,6,2,4]
        System.out.println(s.preorder(new Node(1, Arrays.asList(new Node(3, Arrays.asList(new Node(5), new Node(6))), new Node(2), new Node(4)))));
    }
}