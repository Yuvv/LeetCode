/**
 * 0779-k-th-symbol-in-grammar.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/03/12
 */
public class Solution {
    // n, k is 1-indexed
    public int kthGrammar(int n, int k) {
        // make n, k as 0-indexed
        n--;
        k--;
        // dp(n, k) = dp(n-1, k), if n>0 && k < 2^n-1 / 2
        //          = 1 - dp(n-1, k-2^n-2 / 2), if n>0 && k >= 2^n-1 / 2
        //          = 0, if n=0 && k=0
        int times = 0;
        while (n > 0 && k > 0) {
            int pow = 2 << (n-1);
            pow /= 2;
            if (k >= pow) {
                k -= pow;
                times++;
            }
            n--;
        }
        if (times % 2 == 0) {
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0
        System.out.println(s.kthGrammar(1, 1));
        // 0
        System.out.println(s.kthGrammar(2, 1));
        // 1
        System.out.println(s.kthGrammar(2, 2));
    }
}