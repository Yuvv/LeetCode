/**
 * 2439-minimize-maximum-of-array
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/1/5
 */
public class Solution {
    public int minimizeArrayValue(int[] nums) {
        long max = nums[0];
        long sum = max;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            long avg = sum / (i + 1);
            if (sum % (i + 1) > 0) {
                avg++;
            }
            max = Math.max(max, avg);
        }
        return (int) max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.minimizeArrayValue(new int[] { 3, 7, 1, 6 }));
    }
}
