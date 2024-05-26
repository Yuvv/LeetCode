/**
 * 3162-find-the-number-of-good-pairs-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/05/26
 */
public class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] *= k;
        }
        int cnt = 0;
        for (int a : nums1) {
            for (int b : nums2) {
                if (a % b == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.numberOfPairs(
            new int[]{1,3,4}, new int[]{1,3,4}, 1
        ));
        // 2
        System.out.println(s.numberOfPairs(
            new int[]{1,2,4,12}, new int[]{2,4}, 3
        ));
    }
}