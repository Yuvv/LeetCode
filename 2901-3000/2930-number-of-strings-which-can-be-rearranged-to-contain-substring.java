/**
 * 2930-number-of-strings-which-can-be-rearranged-to-contain-substring
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/11/25
 */
public class Solution {
    public static long MOD = 1000000007L;

    public int stringCount(int n) {
        if (n < 4) {
            return 0;
        }
        long[][][][] dp = new long[n + 1][][][];
        dp[3] = new long[2][3][2];
        dp[3][0][0][0] = 26 * 26 * 26;
        dp[3][0][0][1] = 26 * 26 * 26 - 25 * 25 * 25; // !No(t)
        dp[3][0][1][0] = 26 * 26 * 26 - 25 * 25 * 25; // !No(e)
        dp[3][1][0][0] = 26 * 26 * 26 - 25 * 25 * 25; // !No(l)
        dp[3][0][1][1] = 24 * 3 * 2 + 3 * 2; // Perm(ET..Non(et)) + Perm(EET) + Perm(ETT)
        dp[3][1][0][1] = 24 * 3 * 2 + 3 * 2; // Perm(LT..Non(lt)) + Perm(LLT) + Perm(LTT)
        dp[3][1][1][0] = 24 * 3 * 2 + 3 * 2; // Perm(LE..Non(le)) + Perm(LLE) + Perm(LEE)
        dp[3][0][2][0] = 25 * 3 + 1; // EE..Non(e) + EEE
        dp[3][0][2][1] = 3; // Perm(EET)
        dp[3][1][1][1] = 6; // Perm(LET)
        dp[3][1][2][0] = 3; // Perm(LEE)
        dp[3][1][2][1] = 0;

        for (int i = 4; i <= n; i++) {
            dp[i] = new long[2][3][2];
            for (int x = 0; x < 2; x++) {
                for (int y = 0; y < 3; y++) {
                    for (int z = 0; z < 2; z++) {
                        long res = 23 * dp[i - 1][x][y][z];
                        if (x > 0) {
                            res += dp[i - 1][x - 1][y][z];
                            res %= MOD;
                        } else {
                            res += dp[i - 1][x][y][z];
                            res %= MOD;
                        }
                        if (y > 0) {
                            res += dp[i - 1][x][y - 1][z];
                            res %= MOD;
                        } else {
                            res += dp[i - 1][x][y][z];
                            res %= MOD;
                        }
                        if (z > 0) {
                            res += dp[i - 1][x][y][z - 1];
                            res %= MOD;
                        } else {
                            res += dp[i - 1][x][y][z];
                            res %= MOD;
                        }

                        dp[i][x][y][z] = res;
                    }
                }
            }
        }

        return (int) dp[n][1][2][1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 12
        System.out.println(s.stringCount(4));
        // 1460
        System.out.println(s.stringCount(5));
        // 83943898
        System.out.println(s.stringCount(10));
        // 778066325
        System.out.println(s.stringCount(100000));
    }
}
