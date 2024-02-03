import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

/**
 * 2767-partition-string-into-minimum-beautiful-substrings.java
 *
 * @date 2024/2/3
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    private static final Set<Integer> P5SET;
    static {
        P5SET = new HashSet<>();
        P5SET.add(1);
        P5SET.add(5);
        P5SET.add(25);
        P5SET.add(125);
        P5SET.add(625);
        P5SET.add(3125);
        P5SET.add(15625);
    }
    public int minimumBeautifulSubstrings(String s) {
        int[][] dp = new int[s.length()][];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = new int[s.length()-i];
            if (s.charAt(i) == '1') {
                Arrays.fill(dp[i], -2);
                dp[i][0] = 0;
            } else {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
        }

        for (int i = s.length()-2; i >= 0; i--) {
            if (dp[i][0] == Integer.MAX_VALUE) {
                continue;
            }
            for (int j = 1; j < dp[i].length; j++) {
                int min = Integer.MAX_VALUE;
                if (P5SET.contains(Integer.parseInt(s.substring(i, i+j+1), 2))) {
                    dp[i][j] = 0;
                    continue;
                }
                for (int k = 0; k < j; k++) {
                    int a = dp[i][k];
                    int b = dp[i+k+1][j-k-1];
                    if (a == Integer.MAX_VALUE || b == Integer.MAX_VALUE) {
                        continue;
                    }
                    min = Math.min(min, a+b+1);
                }
                dp[i][j] = min;
            }
        }

        int res = dp[0][s.length()-1];
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res+1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.minimumBeautifulSubstrings("1011"));
        // 3
        System.out.println(s.minimumBeautifulSubstrings("111"));
        // -1
        System.out.println(s.minimumBeautifulSubstrings("0"));
    }
}
