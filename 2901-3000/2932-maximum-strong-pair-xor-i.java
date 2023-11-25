/**
 * 2932-maximum-strong-pair-xor-i
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/11/25
 */
public class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int max = 0;
        for (int x : nums) {
            for (int y : nums) {
                if (Math.abs(x - y) <= Math.min(x, y)) {
                    max = Math.max(max, x ^ y);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 7
        System.out.println(s.maximumStrongPairXor(new int[] { 1, 2, 3, 4, 5 }));
        // 0
        System.out.println(s.maximumStrongPairXor(new int[] { 10, 100 }));
        // 7
        System.out.println(s.maximumStrongPairXor(new int[] { 5, 6, 25, 30 }));
    }
}
