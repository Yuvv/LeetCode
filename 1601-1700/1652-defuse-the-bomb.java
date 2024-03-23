/**
 * 1652-defuse-the-bomb.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/03/23
 */
public class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        if (k > 0) {
            int nextSum = 0;
            for (int i = 0; i < k; i++) {
                nextSum += code[i];
            }
            for (int i = 0; i < code.length; i++) {
                nextSum = nextSum - code[i] + code[(i+k) % code.length];
                res[i] = nextSum;
            }
        } else if (k < 0) {
            k = -k;
            int prevSum = 0;
            for (int i = 0; i < k; i++) {
                prevSum += code[code.length - 1 - i];
            }
            for (int i = 0; i < code.length; i++) {
                res[i] = prevSum;
                prevSum = prevSum - code[(i-k+code.length) % code.length] + code[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [12,10,16,13]
        System.out.println(s.decrypt(new int[]{5,7,1,4}, 3));
        // [12,5,6,13]
        System.out.println(s.decrypt(new int[]{5,7,1,4}, -2));
    }
}