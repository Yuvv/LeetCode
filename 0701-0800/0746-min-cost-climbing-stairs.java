import java.util.Map;
import java.util.HashMap;

/*
 * 0746-min-cost-climbing-stairs.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/27
 */
public class Solution {
    private Map<Integer, Integer> cacheMap;

    public int minCostClimbingStairs(int[] cost) {
        cacheMap = new HashMap<>(cost.length);
        return minCostClimb(cost, -1);
    }

    public int minCostClimb(int[] cost, int fromIdx) {
        if (fromIdx >= cost.length - 2) {
            return 0;
        }
        if (cacheMap.containsKey(fromIdx)) {
            return cacheMap.get(fromIdx);
        }
        int step1 = cost[fromIdx + 1] + minCostClimb(cost, fromIdx + 1);
        int step2 = cost[fromIdx + 2] + minCostClimb(cost, fromIdx + 2);
        int val = Math.min(step1, step2);
        cacheMap.put(fromIdx, val);
        return val;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 15
        System.out.println(s.minCostClimbingStairs(new int[]{10, 15, 20}));
        // 6
        System.out.println(s.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        // others
        for (String arg : args) {
            if (arg != null && arg.length() > 2) {
                String[] ss = arg.substring(1, arg.length() - 1).split(",");
                int[] cost = new int[ss.length];
                for (int i = 0; i < ss.length; i++) {
                    cost[i] = Integer.parseInt(ss[i]);
                }
                System.out.println(s.minCostClimbingStairs(cost));
            }
        }
    }
}