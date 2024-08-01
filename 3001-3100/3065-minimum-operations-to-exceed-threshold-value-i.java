/**
 * 3065-minimum-operations-to-exceed-threshold-value-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/01
 */
public class Solution {
    public int minOperations(int[] nums, int k) {
        int cnt = 0;
        for (int n : nums) {
            if (n < k) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.minOperations(new int[]{2,11,10,1,3}, 10));
    }
}
