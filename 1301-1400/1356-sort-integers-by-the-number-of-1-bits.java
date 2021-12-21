import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

/*
 * 1356-sort-integers-by-the-number-of-1-bits.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/21
 */
public class Solution {
    Map<Integer, Integer> cacheMap = new HashMap<>();

    private int getBitCount(int a) {
        return cacheMap.computeIfAbsent(a, k -> {
            int count = 0;
            while (k > 0) {
                if ((k & 1) > 0) {
                    count++;
                }
                k >>= 1;
            }
            return count;
        });
    }

    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)
            .boxed()
            .sorted((a, b) -> {
                int r = Integer.compare(getBitCount(a), getBitCount(b));
                if (r == 0) {
                    r = Integer.compare(a, b);
                }
                return r;
            })
            .mapToInt(Integer::intValue)
            .toArray();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [0,1,2,4,8,3,5,6,7]
        System.out.println(Arrays.toString(s.sortByBits(new int[] {0,1,2,3,4,5,6,7,8})));
        // [1,2,4,8,16,32,64,128,256,512,1024]
        System.out.println(Arrays.toString(s.sortByBits(new int[] {1024,512,256,128,64,32,16,8,4,2,1})));
    }
}