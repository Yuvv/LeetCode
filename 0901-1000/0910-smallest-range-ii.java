import java.util.Arrays;

/*
 * 0910-smallest-range-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/05
 */
public class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int res = nums[nums.length - 1] - nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            int high = Math.max(nums[nums.length - 1] - k, nums[i] + k);
            int low = Math.min(nums[0] + k, nums[i + 1] - k);
            res = Math.min(res, high - low);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0
        System.out.println(s.smallestRangeII(new int[] {1}, 0));
        // 6
        System.out.println(s.smallestRangeII(new int[] {0,10}, 2));
        // 3
        System.out.println(s.smallestRangeII(new int[] {1,3,6}, 3));
    }
}