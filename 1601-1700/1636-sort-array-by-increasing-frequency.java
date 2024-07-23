import java.util.*;
import java.util.stream.*;

/**
 * 1636-sort-array-by-increasing-frequency.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/23
 */
public class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return IntStream.of(nums).boxed().sorted((a, b) -> {
            int ac = map.get(a);
            int bc = map.get(b);
            if (ac == bc) {
                return b - a;
            }
            return ac - bc;
        }).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [3,1,1,2,2,2]
        System.out.println(Arrays.toString(s.frequencySort(new int[]{1, 1, 2, 2, 2, 3})));
        // [1,3,3,2,2]
        System.out.println(Arrays.toString(s.frequencySort(new int[]{2, 3, 1, 3, 2})));
        // [5,-1,4,4,-6,-6,1,1,1]
        System.out.println(Arrays.toString(s.frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1})));
    }
}
