import java.util.*;
/**
 * 2772-apply-operations-to-make-all-array-elements-equal-to-zero.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/25
 */
public class Solution {
    // AC, but slow
    public boolean checkArray(int[] nums, int k) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0) {
                if (i + k > nums.length) {
                    return false;
                }
                for (int j = i + 1; j <= i+k-1; j++) {
                    if (nums[j] < nums[i]) {
                        return false;
                    }
                    nums[j] -= nums[i];
                }
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.checkArray(new int[] {2,2,3,1,1,0}, 3));
        // false
        System.out.println(s.checkArray(new int[] {1,3,1,1}, 2));
        // true
        System.out.println(s.checkArray(new int[] {0,1,2,3,4,5,4,3,2,0,0}, 4));
    }
}