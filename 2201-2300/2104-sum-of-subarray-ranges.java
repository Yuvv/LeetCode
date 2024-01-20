/**
 * 2104-sum-of-subarray-ranges.java
 *
 * @date 2023/1/20
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    // AC, but beats only 15.27% and it's not O(n)
    // O(n) solution can be done like LC-907
    public long subArrayRanges(int[] nums) {
        long res = 0L;
        int[][] mms = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            mms[i][0] = nums[i];
            mms[i][1] = nums[i];
        }
        for (int len = 1; len < nums.length; len++) {
            for (int i = 0; i + len < nums.length; i++) {
                mms[i][0] = Math.min(mms[i][0], nums[i + len]);
                mms[i][1] = Math.max(mms[i][1], nums[i + len]);
                res += mms[i][1] - mms[i][0];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.subArrayRanges(new int[] { 1, 2, 3 }));
        // 4
        System.out.println(s.subArrayRanges(new int[] { 1, 3, 3 }));
        // 59
        System.out.println(s.subArrayRanges(new int[] { 4, -2, -3, 4, 1 }));
    }
}
