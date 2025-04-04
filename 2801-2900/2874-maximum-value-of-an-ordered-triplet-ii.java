/**
 * 2874-maximum-value-of-an-ordered-triplet-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/04/04
 */
public class Solution {
    public long maximumTripletValue(int[] nums) {
        int[] premax = new int[nums.length];
        int[] sufmax = new int[nums.length];
        premax[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            premax[i] = Math.max(premax[i - 1], nums[i]);
        }
        sufmax[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            sufmax[i] = Math.max(sufmax[i + 1], nums[i]);
        }
        long max = 0L;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] >= premax[i - 1]) {
                continue;
            }
            long value = (long) (premax[i - 1] - nums[i]) * (long) sufmax[i + 1];
            max = Math.max(max, value);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 77
        System.out.println(s.maximumTripletValue(new int[] {12,6,1,2,7}));
        // 133
        System.out.println(s.maximumTripletValue(new int[] {1,10,3,4,19}));
        // 0
        System.out.println(s.maximumTripletValue(new int[] {1,2,3}));
    }
}
