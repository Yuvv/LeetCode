import java.util.*;

/**
 * 1395-count-number-of-teams.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/29
 */
public class Solution {
    public int numTeams(int[] rating) {
        TreeMap<Integer, Integer> treemap = new TreeMap<>();
        int[][] dp = new int[rating.length][2];
        for (int i = rating.length - 1; i >= 0; i--) {
            int rate = rating[i];
            dp[i][0] = treemap.headMap(rate, false).values().stream().mapToInt(Integer::intValue).sum();
            dp[i][1] = treemap.tailMap(rate, false).values().stream().mapToInt(Integer::intValue).sum();
            treemap.put(rate, treemap.getOrDefault(rate, 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < rating.length-2; i++) {
            for (int j = i+1; j < rating.length-1; j++) {
                if (rating[j] > rating[i]) {
                    res += dp[j][1];
                } else if (rating[j] < rating[i]) {
                    res += dp[j][0];
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.numTeams(new int[] {2,5,3,4,1}));
        // 0
        System.out.println(s.numTeams(new int[] {2,1,3}));
        // 4
        System.out.println(s.numTeams(new int[] {1,2,3,4}));
    }
}
