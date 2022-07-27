/*
 * 1004-max-consecutive-ones-iii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/27
 */
public class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = Math.min(k, nums.length);
        int begin = 0;
        int nZero = 0;
        int nOne = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nZero++;
            } else {
                nOne++;
            }
            while (nZero > k) {
                if (nums[begin] == 0) {
                    nZero--;
                } else {
                    nOne--;
                }
                begin++;
            }
            if (nZero <= k) {
                max = Math.max(max, nOne + nZero);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2));
        // 10
        System.out.println(s.longestOnes(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}