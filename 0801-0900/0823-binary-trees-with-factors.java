import java.util.*;

/*
 * 0823-binary-trees-with-factors.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/08/10
 */
public class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        long mod = 1000000007L;
        Map<Integer, Long> map = new HashMap<>();
        Arrays.sort(arr);
        map.put(arr[0], 1L);

        for (int i = 1; i < arr.length; i++) {
            long cur = 1L;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int div = arr[i] / arr[j];
                    if (map.containsKey(div)) {
                        cur += map.get(div) * map.get(arr[j]);
                        cur %= mod;
                    }
                }
            }
            map.put(arr[i], cur);
        }

        long total = 0L;
        for (long val : map.values()) {
            total += val;
            total %= mod;
        }
        return (int) total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.numFactoredBinaryTrees(new int[] {2,4}));
        // 7
        System.out.println(s.numFactoredBinaryTrees(new int[] {2,4,5,10}));
    }
}