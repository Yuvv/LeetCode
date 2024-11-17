/**
 * 3309-maximum-possible-number-by-binary-concatenation.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/11/17
 */
public class Solution {
    public int maxGoodNumber(int[] nums) {
        String a = Integer.toBinaryString(nums[0]);
        String b = Integer.toBinaryString(nums[1]);
        String c = Integer.toBinaryString(nums[2]);
        int max = Math.max(Integer.parseInt(a+b+c, 2), Integer.parseInt(a+c+b, 2));
        max = Math.max(max, Integer.parseInt(b+a+c, 2));
        max = Math.max(max, Integer.parseInt(b+c+a, 2));
        max = Math.max(max, Integer.parseInt(c+a+b, 2));
        max = Math.max(max, Integer.parseInt(c+b+a, 2));
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 30
        System.out.println(s.maxGoodNumber(new int[]{1,2,3}));
        // 1296
        System.out.println(s.maxGoodNumber(new int[]{2,8,16}));
    }
}
