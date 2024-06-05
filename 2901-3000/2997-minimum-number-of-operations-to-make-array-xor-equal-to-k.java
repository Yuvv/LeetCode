/**
 * 2997-minimum-number-of-operations-to-make-array-xor-equal-to-k.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/05
 */
public class Solution {
    public int minOperations(int[] nums, int k) {
        int x = nums[0];
        for (int i = 1; i < nums.length; i++) {
            x ^= nums[i];
        }
        int cnt = 0;
        while (x > 0 || k > 0) {
            if ( (x&1) != (k&1) ) {
                cnt++;
            }
            x >>= 1;
            k >>= 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.minOperations(new int[]{2,1,3,4}, 1));
        // 0
        System.out.println(s.minOperations(new int[]{2,0,2,0}, 0));
    }
}