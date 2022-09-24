import java.util.*;
/*
 * 0740-delete-and-earn.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/09/24
 */
public class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int[][] values = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            values[i][0] = entry.getKey();
            values[i][1] = entry.getKey() * entry.getValue();
            i++;
        }
        int[][] dp = new int[values.length][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // let's iterate
        dp[0][0] = 0;  // not earn at index 0
        dp[0][1] = values[0][1];  // earn at index 0
        if (dp.length > 1) {
            dp[1][0] = values[0][1]; // not earn at index 1
            // earn at index 1
            if (values[0][0] + 1 == values[1][0]) {
                dp[1][1] = values[1][1];
            } else {
                dp[1][1] = dp[0][1] + values[1][1];
            }
        }
        for (i = 2; i < dp.length; i++) {
            // if not earn
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            // if earn
            int a = values[i-2][0];
            int b = values[i-1][0];
            int c = values[i][0];
            if (b + 1 == c) {
                // choose b or c
                dp[i][1] = Math.max(dp[i-2][0], dp[i-2][1]) + values[i][1];
            } else {
                // jsut think about b and c
                dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]) + values[i][1];
            }
        }
        return Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.deleteAndEarn(new int[] {3,2,4}));
        // 9
        System.out.println(s.deleteAndEarn(new int[] {2,2,3,3,3,4}));
    }
}