/*
 * 1437-check-if-all-1s-are-at-least-length-k-places-away.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/08/07
 */
public class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int zeroCount = k + 1;
        int i = 0;
        while (i < nums.length && nums[i] == 0) {
            i++;
        }
        while (i < nums.length) {
            while (i < nums.length && nums[i] == 0) {
                i++;
                zeroCount++;
            }
            if (i < nums.length && nums[i] == 1) {
                if (zeroCount < k) {
                    return false;
                }
                i++;
            }
            zeroCount = 0;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // false
        System.out.println(s.kLengthApart(new int[] {1,0,0,0,1,1,1,1,1,0,0,1,0,0,0,1,0}, 2));
        // true
        System.out.println(s.kLengthApart(new int[] {1,0,0,0,1,0,0,1}, 2));
        // false
        System.out.println(s.kLengthApart(new int[] {1,0,0,1,0,1}, 2));
        // true
        System.out.println(s.kLengthApart(new int[] {0,1,0,0,1,0,0,1,0}, 2));
    }
}