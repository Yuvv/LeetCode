import java.util.*;

/*
 * 0968-binary-tree-cameras.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/06/17
 */
public class Solution {
    public int minCameraCover(TreeNode root) {
        Map<TreeNode, int[]> cacheMap =  new HashMap<>();

        int[] res = getMinCameraCover(root, cacheMap);
        return Math.min(res[1], res[2]);
    }

    int[] getMinCameraCover(TreeNode node, Map<TreeNode, int[]> cacheMap) {
        if (node == null) {
            return new int[] {0, 0, 1};
        }
        if (cacheMap.containsKey(node)) {
            return cacheMap.get(node);
        }
        int[] value = new int[3];
        int[] leftRes = getMinCameraCover(node.left, cacheMap);
        int[] rightRes = getMinCameraCover(node.right, cacheMap);

        // if install camera on current
        int a = 1 + leftRes[0] + rightRes[0];
        // if current node is captured
        int b = leftRes[1] + rightRes[1];
        // current node is not captured and not installed
        int c = leftRes[2] + rightRes[2];
        if (node.left != null) {
            c = Math.min(c, leftRes[2] + rightRes[1]);
        }
        if (node.right != null) {
            c = Math.min(c, leftRes[1] + rightRes[2]);
        }

        // value[0] means when parent node already installed camera
        value[0] = Math.min(a, b);
        // value[1] means when parent node is captured
        value[1] = Math.min(a, c);
        // value[2] means when parent node is no captured and not installed
        value[2] = a;

        cacheMap.put(node, value);
        return value;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.minCameraCover(
            new TreeNode(
                0,
                new TreeNode(0, new TreeNode(0, null, new TreeNode(0)), new TreeNode(0)),
                null
            )
        ));
        // 2
        System.out.println(s.minCameraCover(
            new TreeNode(
                0,
                new TreeNode(
                    0,
                    new TreeNode(
                        0,
                        new TreeNode(0, null, new TreeNode(0)),
                        null),
                    null),
                null
            )
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
