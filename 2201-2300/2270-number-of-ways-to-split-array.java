/**
 * 2270-number-of-ways-to-split-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/01/05
 */
public class Solution {
    public int waysToSplitArray(int[] nums) {
        long[] ss = new long[nums.length];
        ss[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ss[i] = ss[i - 1] + nums[i];
        }
        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (ss[i] >= ss[nums.length - 1] - ss[i]) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.waysToSplitArray(new int[]{10, 4, -8, 7}));
        // 2
        System.out.println(s.waysToSplitArray(new int[]{2, 3, 1, 0}));
    }
}
