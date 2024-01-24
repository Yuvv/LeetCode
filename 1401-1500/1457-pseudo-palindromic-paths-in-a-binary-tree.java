import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1457-pseudo-palindromic-paths-in-a-binary-tree.java
 *
 * @date 2024/1/24
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public int pseudoPalindromicPaths(TreeNode root) {
        // 1 <= Node.val <= 9
        Set<Integer> evenSet = new HashSet<>();
        Set<Integer> oddSet = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            evenSet.add(i);
        }
        List<Integer> cnt = new ArrayList<>();
        cnt.add(0);

        dfs(root, evenSet, oddSet, cnt);

        return cnt.get(0);
    }

    private void dfs(TreeNode node, Set<Integer> evenSet, Set<Integer> oddSet, List<Integer> cntList) {
        if (node == null) {
            return;
        }
        if (evenSet.contains(node.val)) {
            oddSet.add(node.val);
            evenSet.remove(node.val);
        } else {
            evenSet.add(node.val);
            oddSet.remove(node.val);
        }
        if (node.left == null && node.right == null) {
            // leaf node
            if (oddSet.size() < 2) {
                cntList.set(0, cntList.get(0)+1);
            }
        } else {
            if (node.left != null) {
                dfs(node.left, evenSet, oddSet, cntList);
            }
            if (node.right != null) {
                dfs(node.right, evenSet, oddSet, cntList);
            }
        }
        // finally remove current node
        if (evenSet.contains(node.val)) {
            oddSet.add(node.val);
            evenSet.remove(node.val);
        } else {
            evenSet.add(node.val);
            oddSet.remove(node.val);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.pseudoPalindromicPaths(
                    new TreeNode(
                        2,
                        new TreeNode(3, new TreeNode(3), new TreeNode(1)),
                        new TreeNode(1, null, new TreeNode(1))
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
