import java.util.Arrays;

/*
 * 1641-count-sorted-vowel-strings.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/25
 */
public class Solution {
    /**
     * aaaaaa....a
     * eeeeee....e
     * iiiiiii...i
     * ooooooo...o
     * uuuuuuu...u
     * -------------------------------------
     * 构建 dp，dp(i,j)表示第 i 个位置是第 j 个数的可能的情况有多少种
     * 如上图，因为当前位置必须大于等于上一个位置，也就是说上一个位置小于等于当前位置的情况都应该考虑进去
     * 所以，dp(i,j) = sum{dp(i-1,0)~dp(i-1,j)}
     */
    public int countVowelStrings(int n) {
        int[][] dp = new int[n][5];
        Arrays.fill(dp[0], 1);

        // dp(i, j) = sum_0_j {dp(i-1, k)}
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                int sum = 0;
                for (int k = 0; k <= j; k++) {
                    sum += dp[i - 1][k];
                }
                dp[i][j] = sum;
            }
        }

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += dp[n - 1][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.countVowelStrings(1));
        // 15
        System.out.println(s.countVowelStrings(2));
        // 66045
        System.out.println(s.countVowelStrings(33));
    }
}