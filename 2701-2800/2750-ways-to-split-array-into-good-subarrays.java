/**
 * 2750-ways-to-split-array-into-good-subarrays.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/03/15
 */
public class Solution {
    static long MOD = 1000000007L;

    public int numberOfGoodSubarraySplits(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        // remove suffix 0
        while (j >= 0 && nums[j] == 0) {
            j--;
        }
        if (j < 0) {
            return 0;  // all 0
        }
        // remove prefix 0
        while (i < j && nums[i] == 0) {
            i++;
        }
        // get middle 0
        long ways = 1L;
        while (i < j) {
            while (i < j && nums[i] == 1) {
                i++;
            }
            int originI = i;
            while (i < j && nums[i] == 0) {
                i++;
            }
            ways *= i - originI + 1;
            ways %= MOD;
        }
        return (int)ways;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.numberOfGoodSubarraySplits(new int[]{0,1,0,0,1}));
        // 1
        System.out.println(s.numberOfGoodSubarraySplits(new int[]{0,1,0}));
    }
}