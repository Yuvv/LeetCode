/**
 * 2965-find-missing-and-repeated-values.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/06/21
 */
public class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] res = new int[2];
        int[] nums = new int[grid.length * grid.length];
        for (int[] row : grid) {
            for (int num : row) {
                nums[num - 1]++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res[1] = i + 1; // Missing value
            } else if (nums[i] > 1) {
                res[0] = i + 1; // Repeated value
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [2,4]
        System.out.println(s.findMissingAndRepeatedValues(new int[][]{
            {1,3}, {2,2}
        }));
        // [9,5]
        System.out.println(s.findMissingAndRepeatedValues(new int[][]{
            {}, {2,2}
        }));
    }
}