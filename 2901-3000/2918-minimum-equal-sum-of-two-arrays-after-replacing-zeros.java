/**
 * 2918-minimum-equal-sum-of-two-arrays-after-replacing-zeros.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/05/10
 */
public class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0L, sum2 = 0L;
        int zc1 = 0, zc2 = 0;
        for (int n : nums1) {
            if (n == 0) {
                zc1++;
            } else {
                sum1 += n;
            }
        }
        sum1 += zc1;
        for (int n : nums2) {
            if (n == 0) {
                zc2++;
            } else {
                sum2 += n;
            }
        }
        sum2 += zc2;

        if (sum1 == sum2) {
            return sum1;
        }
        if (zc1 == 0 && zc2 == 0 ||
            zc1 == 0 && sum1 < sum2 ||
            zc2 == 0 && sum2 < sum1) {
            return -1;
        }
        return Math.max(sum1, sum2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 12
        System.out.println(s.minSum(new int[]{1,2,3,0,0}, new int[]{0,5,6}));
        // -1
        System.out.println(s.minSum(new int[]{2,0,2,0}, new int[]{1,4}));
        // 257
        System.out.println(s.minSum(
            new int[]{0,17,20,17,5,0,14,19,7,8,16,18,6},
            new int[]{21,1,27,19,2,2,24,21,16,1,13,27,8,5,3,11,13,7,29,7}));
    }
}
