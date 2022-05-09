import java.util.*;

/*
 * 2266-count-number-of-texts.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/09
 */
public class Solution {
    static final long MOD = 1000000007L;
    static final Map<Integer, Map<Integer, Long>> CACHE_MAP = new HashMap<>();

    public long getPossibleCount(int val, int count) {
        Map<Integer, Long> cacheMap = CACHE_MAP.computeIfAbsent(val, k -> new HashMap<>());
        if (cacheMap.containsKey(count)) {
            return cacheMap.get(count);
        }
        int base = 3;
        if (val == 7 || val == 9) {
            base = 4;
        }
        long total = 0L;
        if (count <= base) {
            total += 1 << (count - 1);
        } else {
            for (int i = 1; i <= base; i++) {
                total += getPossibleCount(val, count - i);
            }
        }
        total %= MOD;
        cacheMap.put(count, total);
        return total;
    }

    public int countTexts(String pressedKeys) {
        long total = 1L;
        int i = 0;
        while (i < pressedKeys.length()) {
            char ch = pressedKeys.charAt(i);
            int val = ch - '0';
            int count = 0;
            while (i < pressedKeys.length() && pressedKeys.charAt(i) == ch) {
                i++;
                count++;
            }
            total *= getPossibleCount(val, count);
            total %= MOD;
        }

        return (int) (total % MOD);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 8
        System.out.println(s.countTexts("22233"));
        // 82876089
        System.out.println(s.countTexts("222222222222222222222222222222222222"));
    }
}