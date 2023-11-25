import java.util.Arrays;

/**
 * 1685-sum-of-absolute-differences-in-a-sorted-array
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/11/25
 */
public class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] res = new int[nums.length];
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            sum += Math.abs(nums[i]-nums[0]);
        }
        res[0] = sum;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] - (nums[i]-nums[i-1])*(nums.length-i) + (nums[i]-nums[i-1])*i;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [4,3,5]
        System.out.println(Arrays.toString(s.getSumAbsoluteDifferences(new int[]{2,3,5})));
        // [24,15,13,15,21]
        System.out.println(Arrays.toString(s.getSumAbsoluteDifferences(new int[]{1,4,6,8,10})));
    }
}
