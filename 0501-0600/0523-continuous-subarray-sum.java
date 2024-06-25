import java.util.Map;
import java.util.HashMap;

/**
 * 0523-continuous-subarray-sum.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/25
 */
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int maxPS = nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
            if (nums[i] % k == 0) {
                return true;  // fast return
            }
            map.put(nums[i], i);
            maxPS = Math.max(maxPS, nums[i]);
        }
        System.out.println(java.util.Arrays.toString(nums));
        System.out.println(map);
        for (int i = 0; i < nums.length-1; i++) {
            int x = nums[i];
            while (x <= maxPS) {
                Integer y = map.get(x);
                if (y != null && y - i > 1) {
                    return true;
                }
                x += k;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.checkSubarraySum(new int[] {23,2,4,6,7}, 6));
        // true
        System.out.println(s.checkSubarraySum(new int[] {23,2,6,4,7}, 6));
        // false
        System.out.println(s.checkSubarraySum(new int[] {23,2,6,4,7}, 13));
        // false
        System.out.println(s.checkSubarraySum(new int[] {1,0}, 2));
        // true
        System.out.println(s.checkSubarraySum(new int[] {23,2,4,6,6}, 7));
    }
}