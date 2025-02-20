/**
 * 3452-sum-of-good-numbers.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/02/20
 */
public class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;
        for (int i=0; i < nums.length; i++) {
            if (i-k >= 0 && nums[i] <= nums[i-k]) {
                continue;
            }
            if (i+k < nums.length && nums[i] <= nums[i+k]) {
                continue;
            }
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 12
        System.out.println(s.sumOfGoodNumbers(new int[] {1,3,2,1,5,4}, 2));
        // 2
        System.out.println(s.sumOfGoodNumbers(new int[] {2,1}, 1));
    }
}
