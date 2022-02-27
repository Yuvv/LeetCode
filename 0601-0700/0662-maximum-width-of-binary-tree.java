import java.util.*;

/*
 * 0662-maximum-width-of-binary-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/02/27
 */
public class Solution {
    public int widthOfBinaryTree_tle(TreeNode root) {
        int maxWidth = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            maxWidth = Math.max(maxWidth, size);
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    queue.add(null);
                    queue.add(null);
                } else {
                    queue.add(node.left);
                    queue.add(node.right);
                }
                size--;
            }
            // trim queue
            while (!queue.isEmpty() && queue.peekFirst() == null) {
                queue.poll();
            }
            while (!queue.isEmpty() && queue.peekLast() == null) {
                queue.pollLast();
            }
        }
        return maxWidth;
    }

    public int widthOfBinaryTree(TreeNode root) {
        long maxWidth = 1L;
        Map<TreeNode, Long> nodeMap = new HashMap<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        nodeMap.put(root, 0L);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Long leftVal = nodeMap.get(queue.peekFirst());
            Long rightVal = nodeMap.get(queue.peekLast());
            maxWidth = Math.max(maxWidth, rightVal - leftVal + 1);
            while (size > 0) {
                TreeNode node = queue.poll();
                Long nodeVal = nodeMap.remove(node);
                if (node.left != null) {
                    queue.add(node.left);
                    nodeMap.put(node.left, nodeVal * 2);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    nodeMap.put(node.right, nodeVal * 2 + 1);
                }
                size--;
            }
        }
        return (int) maxWidth;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.widthOfBinaryTree(new TreeNode(
            1,
            new TreeNode(3, new TreeNode(5), new TreeNode(3)),
            new TreeNode(2, null, new TreeNode(9))
        )));
        // 9
        System.out.println(s.widthOfBinaryTree(new TreeNode(
            1,
            new TreeNode(1, new TreeNode(1, new TreeNode(1, new TreeNode(1), null), null), null),
            new TreeNode(1, new TreeNode(1, new TreeNode(1, new TreeNode(1), null), null), null)
        )));
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

    @Override
    public String toString() {
        return "TreeNode(" + val + ", left=" + left + ", right=" + right + ")";
    }
}