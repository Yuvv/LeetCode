/**
 * 2873-maximum-value-of-an-ordered-triplet-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/04/04
 */
public class Solution {
    public long maximumTripletValue(int[] nums) {
        long max = 0L;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] <= nums[j]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    long value = (long) (nums[i] - nums[j]) * (long) nums[k];
                    max = Math.max(max, value);
                }
            }
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
