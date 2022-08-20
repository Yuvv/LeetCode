import java.util.*;

/*
 * 0775-global-and-local-inversions.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/08/20
 */
public class Solution {
    public boolean isIdealPermutation(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i] - i;
            if (diff > 1 || diff < -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isIdealPermutation(new int[] {1, 0, 2}));
        // false
        System.out.println(s.isIdealPermutation(new int[] {1, 2, 0}));
        // true
        System.out.println(s.isIdealPermutation(new int[] {0,1,2,4,3,6,5,7,8,9,11,10}));
    }
}