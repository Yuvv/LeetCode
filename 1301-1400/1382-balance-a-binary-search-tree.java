import java.util.*;

/*
 * 1382-balance-a-binary-search-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/24
 */
public class Solution {
    public void inOrderTravel(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderTravel(root.left, list);
        list.add(root.val);
        inOrderTravel(root.right, list);
    }

    public TreeNode buildBST(List<Integer> list, int from, int to) {
        if (from > to) {
            return null;
        }

        int mid = (from + to) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = buildBST(list, from, mid - 1);
        node.right = buildBST(list, mid + 1, to);
        return node;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> numbers = new ArrayList<>();
        inOrderTravel(root, numbers);
        return buildBST(numbers, 0, numbers.size() - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [2,1,3,null,null,null,4]
        System.out.println(s.balanceBST(
            new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))))
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

    public String toString() {
        return "TreeNode{val=" + val + ", left=" + left + ", right=" + right + "}";
    }
}
