
/*
 * 2096-step-by-step-directions-from-a-binary-tree-node-to-another.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/17
 */
public class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        String[] resArr = new String[2];
        // find root->val path
        walkAndFind(root, new StringBuilder(), startValue, destValue, resArr);

        // remove common prefix
        int i = 0;
        while (i < resArr[0].length() && i < resArr[1].length()
                    && resArr[0].charAt(i) == resArr[1].charAt(i)) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = resArr[0].length() - 1; j >= i; j--) {
            sb.append('U');
        }
        sb.append(resArr[1].substring(i));
        return sb.toString();
    }

    private void walkAndFind(TreeNode node, StringBuilder sb,
                             int startValue, int destValue, String[] resArr) {
        if (resArr[0] != null && resArr[1] != null) {
            return;
        }
        if (node.val == startValue) {
            resArr[0] = sb.toString();
        } else if (node.val == destValue) {
            resArr[1] = sb.toString();
        }
        if (node.left != null) {
            int len = sb.length();
            sb.append('L');
            walkAndFind(node.left, sb, startValue, destValue, resArr);
            sb.delete(len, sb.length());
        }
        if (node.right != null) {
            int len = sb.length();
            sb.append('R');
            walkAndFind(node.right, sb, startValue, destValue, resArr);
            sb.delete(len, sb.length());
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(
                5,
                new TreeNode(1, new TreeNode(3), null),
                new TreeNode(2, new TreeNode(6), new TreeNode(4))
            );
        // "UURL"
        System.out.println(s.getDirections(
            root, 3, 6
        ));
        // "UR"
        System.out.println(s.getDirections(
            root, 6, 4
        ));
        // "UL"
        System.out.println(s.getDirections(
            root, 4, 6
        ));
        // L
        System.out.println(s.getDirections(
            new TreeNode(2, new TreeNode(1), null),
            2, 1
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
