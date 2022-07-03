/*
 * 2317-maximum-xor-after-operations.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/03
 */
public class Solution {
    public int maximumXOR(int[] nums) {
        // every bit can be reset, so we only need to find all bits
        boolean[] hasBits = new boolean[30];
        for (int num : nums) {
            int i = 0;
            while (num > 0) {
                if ((num & 1) > 0) {
                    hasBits[i] = true;
                }
                num >>= 1;
                i++;
            }
        }
        int res = 0;
        for (int i = hasBits.length - 1; i >= 0; i--) {
            res <<= 1;
            if (hasBits[i]) {
                res |= 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 7
        System.out.println(s.maximumXOR(new int[] {3,2,4,6}));
        // 11
        System.out.println(s.maximumXOR(new int[] {1,2,3,9,2}));
    }
}