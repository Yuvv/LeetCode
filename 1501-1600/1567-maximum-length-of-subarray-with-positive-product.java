/**
 * 1567-maximum-length-of-subarray-with-positive-product.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/11
 */
public class Solution {
    public int getMaxLen(int[] nums) {
        int maxLen = 0;
        // 将数组拆分成按 0 分割的小区间，然后在每个区间内看负数有多少，再分奇数和偶数去统计即可
        int i = 0;
        while (i < nums.length) {
            while (i < nums.length && nums[i] == 0) {
                i++;
            }
            int beg = i;
            int minusCount = 0;
            int firstMinusIdx = -1;
            int lastMinusIdx = -1;
            while (i < nums.length && nums[i] != 0) {
                if (nums[i] < 0) {
                    minusCount++;
                    if (firstMinusIdx < 0) {
                        firstMinusIdx = i;
                    }
                    lastMinusIdx = i;
                }
                i++;
            }
            if (minusCount % 2 == 0) {
                maxLen = Math.max(maxLen, i - beg);
            } else {
                maxLen = Math.max(maxLen, i - firstMinusIdx - 1);
                maxLen = Math.max(maxLen, lastMinusIdx - beg);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.getMaxLen(new int[] {1,-2,-3,4}));
        // 3
        System.out.println(s.getMaxLen(new int[] {0,1,-2,-3,-4}));
        // 2
        System.out.println(s.getMaxLen(new int[] {-1,-2,-3,0,1}));
        // 0
        System.out.println(s.getMaxLen(new int[] {0,0,0}));
        // 1
        System.out.println(s.getMaxLen(new int[] {0,0,1}));
    }
}
