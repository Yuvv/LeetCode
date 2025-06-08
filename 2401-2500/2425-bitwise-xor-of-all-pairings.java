/**
 * 2425-bitwise-xor-of-all-pairings.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/06/08
 */
public class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1 = nums1.length % 2;
        int n2 = nums2.length % 2;
        if (n1 == 0 && n2 == 0) {
            return 0;
        }
        int res = 0;
        if (n2 == 1) {
            for (int num : nums1) {
                res ^= num;
            }
        }
        if (n1 == 1) {
            for (int num : nums2) {
                res ^= num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 13
        System.out.println(s.xorAllNums(new int[]{1, 2, 3}, new int[]{10, 2, 5, 0}));
        // 0
        System.out.println(s.xorAllNums(new int[]{1, 2}, new int[]{6, 5}));
    }
}