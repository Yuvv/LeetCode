import java.util.*;

/**
 * 0945-minimum-increment-to-make-array-unique.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/16
 */
public class Solution {
    public int minIncrementForUnique(int[] nums) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int n : nums) {
            treeMap.put(n, treeMap.getOrDefault(n, 0) + 1);
        }
        int next = 0;
        int cnt = 0;
        while (!treeMap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = treeMap.pollFirstEntry();
            next = Math.max(next, entry.getKey() + 1);
            int value = entry.getValue();
            while (value > 1) {
                if (!treeMap.containsKey(next)) {
                    value--;
                    cnt += next - entry.getKey();
                }
                next++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.minIncrementForUnique(new int[]{1,2,2}));
        // 6
        System.out.println(s.minIncrementForUnique(new int[]{3,2,1,2,1,7}));
    }
}