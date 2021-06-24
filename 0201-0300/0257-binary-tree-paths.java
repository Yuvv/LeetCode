import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;


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
 * 0257-binary-tree-paths.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/06/24
 */
public class Solution {
    private List<String> result;
    public List<String> binaryTreePaths(TreeNode root) {
        result = new ArrayList<>();
        // recursivee
        walk(root, new LinkedList<>());
        return result;
    }

    public void walk(TreeNode node, LinkedList<Integer> stack) {
        stack.add(node.val);
        if (node.left == null && node.right == null) {
            // leaf node
            result.add(stack.stream().map(Objects::toString).collect(Collectors.joining("->")));
        } else {
            if (node.left != null) {
                walk(node.left, stack);
            }
            if (node.right != null) {
                walk(node.right, stack);
            }
        }
        stack.pollLast();
    }
}