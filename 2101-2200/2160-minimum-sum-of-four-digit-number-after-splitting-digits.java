import java.util.Arrays;

/*
 * 2160-minimum-sum-of-four-digit-number-after-splitting-digits.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/02/10
 */
public class Solution {
    public int minimumSum(int num) {
        int[] nums = new int[4];
        nums[0] = num / 1000;
        nums[1] = num % 1000 / 100;
        nums[2] = num % 100 / 10;
        nums[3] = num % 10;

        Arrays.sort(nums);
        return nums[0] * 10 + nums[3] + nums[1] * 10 + nums[2];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 52
        System.out.println(s.minimumSum(2932));
        // 13
        System.out.println(s.minimumSum(4009));
    }
}