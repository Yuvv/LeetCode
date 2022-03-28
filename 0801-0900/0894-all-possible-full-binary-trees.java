import java.util.*;

/*
 * 0894-all-possible-full-binary-trees.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/27
 */
public class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>(0);
        }
        if (n == 1) {
            return Collections.singletonList(new TreeNode(0));
        }
        List<TreeNode> list = new ArrayList<>(n / 2);
        for (int i = 1; i < n - 1; i += 2) {
            // since 1<= n <= 20, we don't need cache
            List<TreeNode> leftList = allPossibleFBT(i);
            List<TreeNode> rightList = allPossibleFBT(n - i - 1);
            for (TreeNode ln : leftList) {
                for (TreeNode rn : rightList) {
                    TreeNode root = new TreeNode(0, ln, rn);
                    list.add(root);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
        System.out.println(s.allPossibleFBT(7));
        // [0,0,0]
        System.out.println(s.allPossibleFBT(3));
        // [0]
        System.out.println(s.allPossibleFBT(1));
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
        return "TN(val=" + val + ", left=" + left + ", right=" + right + ")";
    }
}
