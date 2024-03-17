import java.util.Arrays;

/**
 * 2971-find-polygon-with-the-largest-perimeter.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/03/17
 */
public class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long ps = 0L;
        int ak = nums.length - 1;
        for (int i = 0; i < ak; i++) {
            ps += nums[i];
        }
        while (ak > 1 && ps <= nums[ak]) {
            ak--;
            ps -= nums[ak];
        }
        if (ak <= 1) {
            return -1;
        }
        return ps + nums[ak];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 15
        System.out.println(s.largestPerimeter(new int[]{5,5,5}));
        // 12
        System.out.println(s.largestPerimeter(new int[]{1,12,1,2,5,50,3}));
        // -1
        System.out.println(s.largestPerimeter(new int[]{5,5,50}));
    }
}