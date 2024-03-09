/**
 * 2540-minimum-common-value.java
 *
 * @date 2024/3/9
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else {
                while (i < nums1.length && nums1[i] < nums2[j]) {
                    i++;
                }
                if (i < nums1.length) {
                    while (j < nums2.length && nums1[i] > nums2[j]) {
                        j++;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.getCommon(new int[] { 1, 2, 3 }, new int[] { 2, 4 }));
        // 2
        System.out.println(s.getCommon(new int[] { 1, 2, 3, 6 }, new int[] { 2, 3, 4, 5 }));
    }
}
