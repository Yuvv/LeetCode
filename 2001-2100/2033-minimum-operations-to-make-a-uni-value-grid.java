import java.util.*;
/**
 * 2033-minimum-operations-to-make-a-uni-value-grid.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/03/30
 */
public class Solution {
    public int minOperations(int[][] grid, int x) {
        int N = grid.length * grid[0].length;
        int[] nums = new int[N];
        int i = 0;
        for (int[] row : grid) {
            for (int n : row) {
                nums[i++] = n;
            }
        }
        Arrays.sort(nums);
        int median = nums[N / 2];
        int minOp = 0;
        for (int n : nums) {
            int diff = Math.abs(n - median);
            if (diff % x != 0) {
                return -1;
            }
            minOp += diff / x;
        }
        return minOp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.minOperations(
            new int[][]{{2,4}, {6,8}},
            2
        ));
        // 5
        System.out.println(s.minOperations(
            new int[][]{{1,5}, {2,3}},
            1
        ));
        // -1
        System.out.println(s.minOperations(
            new int[][]{{1,2}, {3,4}},
            2
        ));
    }
}