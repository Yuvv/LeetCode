import java.util.*;

/**
 * 2461-maximum-sum-of-distinct-subarrays-with-length-k.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/11/19
 */
public class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0L;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        // sum
        long mxsum = 0L;
        if (map.size() == k) {
            mxsum = sum;
        }
        for (int i = k; i < nums.length; i++) {
            int j = i - k;
            sum = sum + nums[i] - nums[j];
            if (nums[i] != nums[j]) {
                map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
                int nj = map.get(nums[j]);
                if (nj == 1) {
                    map.remove(nums[j]);
                } else {
                    map.put(nums[j], nj-1);
                }
            }
            if (map.size() == k) {
                mxsum = Math.max(mxsum, sum);
            }
        }
        return mxsum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 15
        System.out.println(s.maximumSubarraySum(
            new int[]{1,5,4,2,9,9,9}, 3
        ));
        // 0
        System.out.println(s.maximumSubarraySum(
            new int[]{4,4,4}, 3
        ));
    }
}
