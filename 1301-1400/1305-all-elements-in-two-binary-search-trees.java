import java.util.*;

/*
 * 1305-all-elements-in-two-binary-search-trees.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/27
 */
public class Solution {

    public void dfs(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(list, node.left);
        list.add(node.val);
        dfs(list, node.right);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();

        dfs(nums1, root1);
        dfs(nums2, root2);

        // merge two list
        int i = 0, j = 0;
        List<Integer> resList = new ArrayList<>(nums1.size() + nums2.size());
        while (i < nums1.size() && j < nums2.size()) {
            while (i < nums1.size() && j < nums2.size()
                    && nums1.get(i).compareTo(nums2.get(j)) <= 0) {
                resList.add(nums1.get(i));
                i++;
            }
            while (i < nums1.size() && j < nums2.size()
                    && nums2.get(j).compareTo(nums1.get(i)) <= 0) {
                resList.add(nums2.get(j));
                j++;
            }
        }
        while (i < nums1.size()) {
            resList.add(nums1.get(i));
            i++;
        }
        while (j < nums2.size()) {
            resList.add(nums2.get(j));
            j++;
        }
        return resList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [0,1,1,2,3,4]
        System.out.println(s.getAllElements(
            new TreeNode(2, new TreeNode(1), new TreeNode(4)),
            new TreeNode(1, new TreeNode(0), new TreeNode(3))
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
