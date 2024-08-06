/**
 * 3131-find-the-integer-added-to-array-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/06
 */
public class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        int min1 = nums1[0];
        for (int n : nums1) {
            min1 = Math.min(min1, n);
        }
        int min2 = nums2[0];
        for (int n : nums2) {
            min2 = Math.min(min2, n);
        }
        return min2 - min1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.addedInteger(new int[] {2,6,4}, new int[] {9,7,5}));
        // -5
        System.out.println(s.addedInteger(new int[] {10}, new int[] {5}));
        // 0
        System.out.println(s.addedInteger(new int[] {1,1,1,1}, new int[] {1,1,1,1}));
    }
}
