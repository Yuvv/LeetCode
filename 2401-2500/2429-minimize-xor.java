/**
 * 2429-minimize-xor.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/06/08
 */
public class Solution {
    public int minimizeXor(int num1, int num2) {
        int bc = 0;
        while (num2 > 0) {
            if ((num2 & 1) == 1) {
                bc++;
            }
            num2 >>= 1;
        }
        int[] bits = new int[32];
        int i = 0;
        while (num1 > 0) {
            if ((num1 & 1) == 1) {
                bits[i] = 1;
            }
            i++;
            num1 >>= 1;
        }
        int[] ans = new int[32];
        for (i = ans.length-1; i >= 0 && bc > 0; i--) {
            if (bits[i] == 1) {
                ans[i] = 1;
                bc--;
            }
        }
        if (bc > 0) {
            for (i = 0; i < ans.length && bc > 0; i++) {
                if (ans[i] == 0) {
                    ans[i] = 1;
                    bc--;
                }
            }
        }
        int res = 0;
        for (i = 0; i < ans.length; i++) {
            res |= (ans[i] << i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.minimizeXor(3, 5));
        // 3
        System.out.println(s.minimizeXor(1, 12));
    }
}
