import java.util.*;

/*
 * 0518-coin-change-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/09/03
 */
public class Solution {
    private Map<Integer, Map<Integer, Integer>> cacheMap;

    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        this.cacheMap = new HashMap<>();  // init every time
        Arrays.sort(coins);
        return change(amount, coins, 0);
    }

    public int change(int amount, int[] coins, int fromIdx) {
        if (fromIdx >= coins.length || coins[fromIdx] > amount) {
            return 0;
        }
        Map<Integer, Integer> map = cacheMap.computeIfAbsent(fromIdx, k -> new HashMap<>());
        if (map.containsKey(amount)) {
            return map.get(amount);
        }
        int count = 0;
        int i = 0;
        int base = 0;
        while (base <= amount) {
            if (base == amount) {
                count += 1;
            } else {
                count += change(amount-base, coins, fromIdx+1);
            }
            base += coins[fromIdx];
        }

        map.put(amount, count);
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.change(5, new int[] {1,2,5}));
        // 0
        System.out.println(s.change(3, new int[] {2}));
        // 1
        System.out.println(s.change(10, new int[] {10}));
        //
        System.out.println(s.change(500, new int[] {
            16, 17, 21, 28, 36, 40, 45, 46, 50, 51, 55, 73, 75, 82, 107, 110, 117, 120, 122, 123, 124, 128,
            130, 134, 137, 142, 155, 162, 163, 168, 169, 171, 172, 173, 184, 196, 202, 208, 213, 218, 224,
            227, 230, 232, 235, 245, 253, 255, 260, 269, 271, 279, 283, 284, 292, 295, 300, 302, 306, 311,
            312, 321, 324, 325, 337, 345, 361, 367, 374, 375, 379, 387, 389, 394, 408, 409, 411, 415, 431,
            433, 435, 444, 456, 466, 469, 475, 476, 482, 492, 499
        }));
    }
}