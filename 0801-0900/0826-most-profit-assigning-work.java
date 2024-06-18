import java.util.*;
/**
 * 0826-most-profit-assigning-work.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/18
 */
public class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < difficulty.length; i++) {
            treeMap.put(difficulty[i], Math.max(profit[i], treeMap.getOrDefault(difficulty[i], 0)));
        }
        Map.Entry<Integer, Integer> entry = treeMap.firstEntry();
        int max = entry.getValue();
        while (entry != null) {
            entry = treeMap.higherEntry(entry.getKey());
            if (entry != null) {
                if (entry.getValue() < max) {
                    treeMap.put(entry.getKey(), max);
                } else {
                    max = entry.getValue();
                }
            }
        }
        int res = 0;
        for (int w : worker) {
            entry = treeMap.lowerEntry(w+1);
            if (entry == null) {
                continue;
            }
            res += entry.getValue();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 100
        System.out.println(s.maxProfitAssignment(
            new int[] {2,4,6,8,10},
            new int[] {10,20,30,40,50},
            new int[] {4,5,6,7}
        ));
        // 0
        System.out.println(s.maxProfitAssignment(
            new int[] {85, 47, 57},
            new int[] {24, 66, 99},
            new int[] {40, 25, 25}
        ));
    }
}