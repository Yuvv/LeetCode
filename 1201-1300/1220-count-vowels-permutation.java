/**
 * 1220-count-vowels-permutation.java
 *
 * @date 2024/1/28
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public static long MOD = 1000000007L;

    public int countVowelPermutation(int n) {
        long[][] dp = new long[n][5];
        for (int i = 0; i < 5; i++) {
            dp[n-1][i] = 1L;
        }
        for (int i = n-2; i >= 0; i--) {
            // 'a'..'e'
            dp[i][0] = dp[i+1][1];
            // 'e'..'a' || 'a'..'i'
            dp[i][1] = (dp[i+1][0] + dp[i+1][2]) % MOD;
            // ! ('i'..'i')
            dp[i][2] = (dp[i+1][0] + dp[i+1][1] + dp[i+1][3] + dp[i+1][4]) % MOD;
            // 'o'..'i' || 'o'..'u'
            dp[i][3] = (dp[i+1][2] + dp[i+1][4]) % MOD;
            // 'u'..'a'
            dp[i][4] = dp[i+1][0];
        }

        long res = 0L;
        for (int i = 0; i < 5; i++) {
            res += dp[0][i];
            res %= MOD;
        }
        return (int)(res);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.countVowelPermutation(1));
        // 10
        System.out.println(s.countVowelPermutation(2));
        // 68
        System.out.println(s.countVowelPermutation(5));
        // 759959057
        System.out.println(s.countVowelPermutation(20000));
    }
}
