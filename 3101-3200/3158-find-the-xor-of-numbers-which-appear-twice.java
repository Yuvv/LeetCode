/**
 * 3158-find-the-xor-of-numbers-which-appear-twice.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/07
 */
public class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        // 1 <= nums[i] <= 50
        int[] cntarr = new int[51];
        for (int x : nums) {
            cntarr[x]++;
        }
        int res = 0;
        for (int i = 0; i < cntarr.length; i++) {
            if (cntarr[i] == 2) {
                res ^= i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.duplicateNumbersXOR(new int[] {1,2,1,3}));
        // 0
        System.out.println(s.duplicateNumbersXOR(new int[] {1,2,3}));
        // 3
        System.out.println(s.duplicateNumbersXOR(new int[] {1,2,2,1}));
    }
}
