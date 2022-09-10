/*
 * 0988-smallest-string-starting-from-leaf.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/09/04
 */
public class Solution {
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, 0, new StringBuilder());
    }

    public String dfs(TreeNode root, int from, StringBuilder sb) {
        sb.delete(from, sb.length());
        char ch = (char)('a' + root.val);
        sb.append(ch);
        if (root.left == null && root.right == null) {
            String res = sb.reverse().toString();
            sb.reverse();
            return res;
        }
        String candidate = null;
        if (root.left != null) {
            candidate = dfs(root.left, from + 1, sb);
        }
        if (root.right != null) {
            String right = dfs(root.right, from + 1, sb);
            if (candidate == null) {
                candidate = right;
            } else {
                if (candidate.compareTo(right) > 0) {
                    candidate = right;
                }
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "dba"
        System.out.println(s.smallestFromLeaf(
            new TreeNode(
                0,
                new TreeNode(1, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(5), new TreeNode(6))
            )
        ));
        // "hud"
        System.out.println(s.smallestFromLeaf(
            new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
            )
        ));
        // "bae"
        System.out.println(s.smallestFromLeaf(
            new TreeNode(
                4,
                new TreeNode(0, new TreeNode(1), null),
                new TreeNode(1)
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
