import java.util.*;
/**
 * 3152-special-array-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/24
 */
public class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        int last = nums[0] % 2;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i] % 2;
            if ((last ^ cur) == 0) {
                treeSet.add(i);
            }
            last = cur;
        }
        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            Integer h = treeSet.higher(q[0]);
            res[i] = h == null || h > q[1];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [false]
        System.out.println(Arrays.toString(s.isArraySpecial(new int[] {3,4,1,2,6}, new int[][]{{0,4}})));
        // [false,true]
        System.out.println(Arrays.toString(s.isArraySpecial(new int[] {4,3,1,6}, new int[][]{{0,2},{2,3}})));
    }
}