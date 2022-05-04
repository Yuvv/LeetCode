import java.util.*;

/*
 * 1711-count-good-meals.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/04
 */
public class Solution {
    static final int[] POWER_OF_2 = new int[] {
        1,
        1 << 1,
        1 << 2,
        1 << 3,
        1 << 4,
        1 << 5,
        1 << 6,
        1 << 7,
        1 << 8,
        1 << 9,
        1 << 10,
        1 << 11,
        1 << 12,
        1 << 13,
        1 << 14,
        1 << 15,
        1 << 16,
        1 << 17,
        1 << 18,
        1 << 19,
        1 << 20,
        1 << 21
    };

    public int countPairs(int[] deliciousness) {
        long sum = 0L;
        Map<Integer, Integer> map = new HashMap<>();
        for (int delic : deliciousness) {
            map.put(delic, map.getOrDefault(delic, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for (int other : POWER_OF_2) {
                int target = other - entry.getKey();
                if (map.containsKey(target)) {
                    if (target == entry.getKey()) {
                        // 注意这里没有除2，把他当作排列，因为最后会再除2
                        sum += entry.getValue().longValue() * (entry.getValue().longValue() - 1L);
                    } else {
                        sum += entry.getValue().longValue() * map.get(target).longValue();
                    }
                }
            }
        }

        return (int) (sum / 2L % 1000000007L);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.countPairs(new int[] {1,3,5,7,9}));
        // 15
        System.out.println(s.countPairs(new int[] {1,1,1,3,3,3,7}));
    }
}