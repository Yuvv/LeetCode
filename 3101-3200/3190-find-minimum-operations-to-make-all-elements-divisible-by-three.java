/**
 * 3190-find-minimum-operations-to-make-all-elements-divisible-by-three.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/23
 */
public class Solution {
    public int minimumOperations(int[] nums) {
        int cnt = 0;
        for (int n : nums) {
            if (n % 3 != 0) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.minimumOperations(new int[] {1,2,3,4}));
    }
}