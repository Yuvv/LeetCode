import java.util.*;
import java.util.stream.*;

/**
 * 2191-sort-the-jumbled-numbers.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/24
 */
public class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (n == 0) {
                map.put(n, mapping[n]);
                continue;
            }
            int w = 0;
            int nc = n;
            int base = 1;
            while (nc > 0) {
                w += mapping[nc % 10]*base;
                nc /= 10;
                base *= 10;
            }
            map.put(n, w);
        }
        return IntStream.of(nums).boxed().sorted((a, b) -> {
            int ac = map.get(a);
            int bc = map.get(b);
            return ac - bc;
        }).mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [338,38,991]
        System.out.println(Arrays.toString(s.sortJumbled(
            new int[]{8,9,4,0,2,1,3,5,7,6},
            new int[]{991,338,38}
        )));
        // [123,456,789]
        System.out.println(Arrays.toString(s.sortJumbled(
            new int[]{0,1,2,3,4,5,6,7,8,9},
            new int[]{789,456,123}
        )));
    }
}
