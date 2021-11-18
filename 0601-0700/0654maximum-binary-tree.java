import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode(val=" + val + ", left=" + left + ", right=" + right + ")";
    }
}

/*
 * 0654maximum-binary-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/18
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeMap<Integer, Integer> numIdxMap = new TreeMap<>(Comparator.reverseOrder());

        for (int i = 0 ; i < nums.length; i++) {
            numIdxMap.put(nums[i], i);
        }

        TreeNode parent = new TreeNode(0);
        buildTree(parent, true, 0, nums.length - 1, numIdxMap);
        return parent.left;
    }

    public void buildTree(TreeNode parent, boolean leftNode, int lo, int hi,
                         TreeMap<Integer, Integer> map) {
        if (lo < hi) {
            return;
        }
        Map.Entry<Integer, Integer> maxNumIdx = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxNumIdx = entry;
            if (maxNumIdx.getValue() <= hi && maxNumIdx.getValue() >= lo) {
                break;
            }
        }
        if (maxNumIdx == null) {
            return;
        }

        TreeNode curNode = new TreeNode(maxNumIdx.getKey());
        if (leftNode) {
            // left
            parent.left = curNode;
        } else {
            // right
            parent.right = curNode;
        }
        buildTree(curNode, true, lo, maxNumIdx.getValue() - 1, map);
        buildTree(curNode, false, maxNumIdx.getValue() + 1, hi, map);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // [6,3,5,null,2,0,null,null,1]
        System.out.println(s.constructMaximumBinaryTree(new int[] {3,2,1,6,0,5}));
        // [3,null,2,null,1]
        System.out.println(s.constructMaximumBinaryTree(new int[] {3,2,1}));
    }
}