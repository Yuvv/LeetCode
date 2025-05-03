/**
 * 3392-count-subarrays-of-length-three-with-a-condition.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/05/03
 */
public class Solution {
    // 3 <= nums.length <= 100
    // -100 <= nums[i] <= 100
    public int countSubarrays(int[] nums) {
        int mc = 0;
        int sum = nums[0]+nums[1];
        for (int i = 2; i < nums.length; i++) {
            sum += nums[i];
            if (sum*2 == nums[i-1]*3) {
                mc++;
            }
            sum -= nums[i-2];
        }
        return mc;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.countSubarrays(new int[]{1,2,1,4,1}));
        // 0
        System.out.println(s.countSubarrays(new int[]{1, 1, 1}));
    }
}
