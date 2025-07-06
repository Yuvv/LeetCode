/**
 * 2784-check-if-array-is-good.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/07/06
 */
public class Solution {
    public boolean isGood(int[] nums) {
        int[] arr = new int[nums.length];
        for (int n : nums) {
            if (n >= nums.length) {
                return false;
            }
            arr[n]++;
            if (n == nums.length-1) {
                if (arr[n] > 2) {
                    return false;
                }
            } else if (n < nums.length && arr[n] > 1) {
                return false;
            }
        }
        return arr[nums.length-1] == 2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // false
        System.out.println(s.isGood(new int[]{2, 1, 3}));
        // true
        System.out.println(s.isGood(new int[]{1,3,3,2}));
        // true
        System.out.println(s.isGood(new int[]{1,1}));
        // false
        System.out.println(s.isGood(new int[]{3,4,4,1,2,1}));
    }
}