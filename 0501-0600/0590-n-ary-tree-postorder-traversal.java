import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;

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


/*
 * 0590-n-ary-tree-postorder-traversal.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/07/19
 */
public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);
        LinkedList<Integer> postStack = new LinkedList<>();
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            postStack.push(node.val);
            if (node.children != null && !node.children.isEmpty()) {
                for (Node en : node.children) {
                    stack.push(en);
                }
            }
        }
        while (!postStack.isEmpty()) {
            resultList.add(postStack.pop());
        }
        return resultList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [5,6,3,2,4,1]
        System.out.println(s.postorder(new Node(1, Arrays.asList(new Node(3, Arrays.asList(new Node(5), new Node(6))), new Node(2), new Node(4)))));
    }
}