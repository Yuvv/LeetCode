/*
 * 0540-single-element-in-a-sorted-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/20
 */
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if ((mi - lo) % 2 == 0) {
                if (nums[mi] == nums[mi - 1]) {
                    hi = mi - 2;
                } else {
                    lo = mi;
                }
            } else {
                if (nums[mi] == nums[mi - 1]) {
                    lo = mi + 1;
                } else {
                    hi = mi - 1;
                }
            }
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.singleNonDuplicate(new int[] {2}));
        // 2
        System.out.println(s.singleNonDuplicate(new int[] {1,1,2}));
        // 2
        System.out.println(s.singleNonDuplicate(new int[] {2,3,3}));
        // 2
        System.out.println(s.singleNonDuplicate(new int[] {1,1,2,3,3,4,4,8,8}));
        // 10
        System.out.println(s.singleNonDuplicate(new int[] {3,3,7,7,10,11,11}));
    }
}