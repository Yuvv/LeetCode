/**
 * 3487-maximum-unique-subarray-sum-after-deletion.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/07/26
 */
public class Solution {
    // 1 <= nums.length <= 100
    // -100 <= nums[i] <= 100
    public int maxSum(int[] nums) {
        boolean[] seen = new boolean[101];
        int maxMZ = -200;
        int sum = 0;
        for (int n : nums) {
            if (n <= 0 ) {
                maxMZ = Math.max(maxMZ, n);
                continue;
            } else if (!seen[n]) {
                sum += n;
                seen[n] = true;
            }
        }
        if (sum == 0) {
            return maxMZ;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 15
        System.out.println(s.maxSum(new int[]{1,2,3,4,5}));
        // 1
        System.out.println(s.maxSum(new int[]{1,1,0,1,1}));
        // 3
        System.out.println(s.maxSum(new int[]{1,2,-1,-2,1,0,-1}));
    }
}