/*
 * 2529-maximum-count-of-positive-integer-and-negative-integer.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/01/14
 */
public class Solution {
    public int maximumCount(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (nums[m] < 0) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        if (i < nums.length && nums[i] < 0) {
            i++;
        }
        j = i;
        while (j < nums.length && nums[j] == 0) {
            j++;
        }
        return Math.max(i, nums.length - j);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.maximumCount(
            new int[] {-2,-1,-1,1,2,3}
        ));
        // 3
        System.out.println(s.maximumCount(
            new int[] {-3,-2,-1,0,0,1,2}
        ));
        // 4
        System.out.println(s.maximumCount(
            new int[] {5,20,66,1314}
        ));
    }
}