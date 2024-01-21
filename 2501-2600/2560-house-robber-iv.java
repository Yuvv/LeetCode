import java.util.HashMap;
import java.util.Map;

/**
 * 2560-house-robber-iv.java
 *
 * @date 2024/1/21
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public int minCapability(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];
        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        while (min < max) {
            int mid = (min + max) / 2;
            if (isPossible(nums, k, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean isPossible(int[] nums, int k, int val) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= val) {
                cnt++;
                i++;
            }
            if (cnt >= k) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.minCapability(new int[] { 2, 3, 5, 9 }, 2));
        // 2
        System.out.println(s.minCapability(new int[] { 2, 7, 9, 3, 1 }, 2));
    }
}
