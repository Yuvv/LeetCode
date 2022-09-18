/*
 * 2091-removing-minimum-and-maximum-from-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/09/18
 */
public class Solution {
    public int minimumDeletions_2pass(int[] nums) {
        int min = nums[0], max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int maxDis = 0;
        int i = -1, j;
        for (j = 0; j < nums.length; j++) {
            if (nums[j] == min || nums[j] == max) {
                maxDis = Math.max(maxDis, j - i - 1);
                i = j;
            }
        }
        maxDis = Math.max(maxDis, j - i - 1);
        return nums.length - maxDis;
    }
    // 1pass - since nums are distinct
    public int minimumDeletions(int[] nums) {
        int mini = 0;
        int maxi = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[mini]) {
                mini = i;
            }
            if (nums[i] > nums[maxi]) {
                maxi = i;
            }
        }
        int left = Math.min(mini, maxi);
        int right = Math.max(mini, maxi);

        return nums.length - Math.max(left, Math.max(nums.length - right, right - left) - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.minimumDeletions(new int[] {2,10,7,5,4,1,8,6}));
        // 3
        System.out.println(s.minimumDeletions(new int[] {0,-4,19,1,8,-2,-3,5}));
        // 1
        System.out.println(s.minimumDeletions(new int[] {101}));
    }
}