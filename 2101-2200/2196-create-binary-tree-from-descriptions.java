import java.util.*;

/**
 * 2196-create-binary-tree-from-descriptions.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/15
 */

public class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> childSet = new HashSet<>();
        for (int[] desc : descriptions) {
            childSet.add(desc[1]);
            TreeNode pNode = nodeMap.computeIfAbsent(desc[0], k -> new TreeNode(k));
            TreeNode cNode = nodeMap.computeIfAbsent(desc[1], k -> new TreeNode(k));
            if (desc[2] ==1) {
                pNode.left = cNode;
            } else {
                pNode.right = cNode;
            }
        }
        for (Map.Entry<Integer, TreeNode> entry : nodeMap.entrySet()) {
            if (!childSet.contains(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [50,20,80,15,17,19]
        System.out.println(s.createBinaryTree(
            new int[][]{{20,15,1}, {20,17,0}, {50,20,1}, {50,80,0}, {80,19,1}}
        ));
        // [1,2,null,null,3,4]
        System.out.println(s.createBinaryTree(
            new int[][]{{1,2,1}, {2,3,0}, {3,4,1}}
        ));
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

