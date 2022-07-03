/*
 * 0376-wiggle-subsequence.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/03
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int count = 1;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] > nums[i - 1]) {
                while (i < nums.length && nums[i] >= nums[i - 1]) {
                    i++;
                }
                count++;
            } else if (nums[i] < nums[i - 1]) {
                while (i < nums.length && nums[i] <= nums[i - 1]) {
                    i++;
                }
                count++;
            } else {
                // for equals
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.wiggleMaxLength(new int[] {1,7,4,9,1,5}));
        // 7
        System.out.println(s.wiggleMaxLength(new int[] {1,17,5,10,13,15,10,5,16,8}));
        // 2
        System.out.println(s.wiggleMaxLength(new int[] {1,2,3,4,5,6,7,8,9}));
    }
}