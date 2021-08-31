import java.util.*;

/*
// Definition for a Node.
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curList = new ArrayList<>(size);
            while (size > 0) {
                Node node = queue.poll();
                curList.add(node.val);
                size--;
                if (node.children != null) {
                    queue.addAll(node.children);
                }
            }
            resultList.add(curList);
        }
        return resultList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[1],[3,2,4],[5,6]]
        System.out.println(s.levelOrder(new Node(1, Arrays.asList(new Node(3, Arrays.asList(new Node(5), new Node(6))), new Node(2), new Node(4)))));
    }
}