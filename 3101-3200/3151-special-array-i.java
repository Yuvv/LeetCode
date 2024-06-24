/**
 * 3151-special-array-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/24
 */
public class Solution {
    public boolean isArraySpecial(int[] nums) {
        int last = nums[0] % 2;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i] % 2;
            if ((last ^ cur) == 0) {
                return false;
            }
            last = cur;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isArraySpecial(new int[] {1}));
        // true
        System.out.println(s.isArraySpecial(new int[] {2,1,4}));
        // false
        System.out.println(s.isArraySpecial(new int[] {4,3,1,6}));
    }
}