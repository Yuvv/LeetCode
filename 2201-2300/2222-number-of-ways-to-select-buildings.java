
/**
 * 2222-number-of-ways-to-select-buildings.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2026/07/07
 */
public class Solution {
    public long numberOfWays(String s) {
        // get suffixSum of 0 and 1
        int[][] suffixSum = new int[2][s.length()+1];
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                suffixSum[0][i] = suffixSum[0][i+1] + 1;
                suffixSum[1][i] = suffixSum[1][i+1];
            } else {
                suffixSum[0][i] = suffixSum[0][i+1];
                suffixSum[1][i] = suffixSum[1][i+1] + 1;
            }
        }
        // dp2[][i] is the result when build "01"/"10" from index "i"
        // dp2[][i] = build2(i) + dp[][i+1]
        // build2(i) = suffixSum[0][i+1] if s[i] == '0'
        //           = suffixSum[1][i+1] if s[i] == '1'
        long[][] dp2 = new long[2][s.length()];
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp2[0][i] = suffixSum[1][i+1] + dp2[0][i+1];
                dp2[1][i] = dp2[1][i+1];
            } else {
                dp2[0][i] = dp2[0][i+1];
                dp2[1][i] = suffixSum[0][i+1] + dp2[1][i+1];
            }
        }

        // dp[i] is the result when build from index "i"
        // dp[i] = build(i) + dp[i+1]
        // build(i) = dp2[0][i+1] if s[i] == '1'
        //          = dp2[1][i+1] if s[i] == '0'
        long[] dp3 = new long[s.length()];
        for (int i = s.length() - 3; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp3[i] = dp2[1][i+1] + dp3[i+1];
            } else {
                dp3[i] = dp2[0][i+1] + dp3[i+1];
            }
        }

        return dp3[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.numberOfWays("001101"));
        // 0
        System.out.println(s.numberOfWays("111000"));
    }
}