import java.util.Map;
import java.util.HashMap;

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
 * 0337-house-robber-iii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/05
 */
public class Solution {
    private Map<TreeNode, Integer> cacheMap = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (cacheMap.containsKey(root)) {
            return cacheMap.get(root);
        }
        // rob root
        int total1 = 0;
        total1 += root.val;
        if (root.left != null) {
            if (root.left.left != null) {
                total1 += rob(root.left.left);
            }
            if (root.left.right != null) {
                total1 += rob(root.left.right);
            }
        }
        if (root.right != null) {
            if (root.right.left != null) {
                total1 += rob(root.right.left);
            }
            if (root.right.right != null) {
                total1 += rob(root.right.right);
            }
        }
        // not rob root
        int total2 = 0;
        total2 += rob(root.left);
        total2 += rob(root.right);

        int res = Math.max(total1, total2);
        cacheMap.put(root, res);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 7
        System.out.println(s.rob(new TreeNode(
            3,
            new TreeNode(
                2,
                null,
                new TreeNode(3)
            ),
            new TreeNode(
                3,
                null,
                new TreeNode(1)
            )
        )));
        // 9
        System.out.println(s.rob(new TreeNode(
            3,
            new TreeNode(
                4,
                new TreeNode(1),
                new TreeNode(3)
            ),
            new TreeNode(
                5,
                null,
                new TreeNode(1)
            )
        )));
    }
}