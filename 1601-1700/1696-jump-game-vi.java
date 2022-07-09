import java.util.*;

/*
 * 1696-jump-game-vi.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/09
 */
public class Solution {
    public int maxResult(int[] nums, int k) {
        // dp(i) means the max score you can get when you stand at position i
        // so, dp(i) = dp(i) + MAX(dp(i+1)..dp(i+k))
        int[] dp = new int[nums.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        dp[nums.length - 1] = nums[nums.length - 1];
        map.put(dp[nums.length - 1], 1);
        for (int i = nums.length - 2; i >= 0; i--) {
            dp[i] = nums[i] + map.lastKey();
            if (i + k < nums.length) {
                Integer val = map.get(dp[i + k]);
                if (val == 1) {
                    map.remove(dp[i + k]);
                } else {
                    map.put(dp[i + k], val - 1);
                }
            }
            map.put(dp[i], map.getOrDefault(dp[i], 0) + 1);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 7
        System.out.println(s.maxResult(
            new int[] {1,-1,-2,4,-7,3}, 2
        ));
        // 17
        System.out.println(s.maxResult(
            new int[] {10,-5,-2,4,0,3}, 3
        ));
    }
}