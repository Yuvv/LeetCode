import java.util.Arrays;
/**
 * 0976-largest-perimeter-triangle.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/02/21
 */
public class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.largestPerimeter(new int[]{2, 1, 2}));
        // 0
        System.out.println(s.largestPerimeter(new int[]{1, 2, 1, 10}));
    }
}
