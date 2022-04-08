import java.util.*;
/*
 * 1409-queries-on-a-permutation-with-key.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/08
 */
public class Solution {
    // 没有算法，直接模拟。。。
    public int[] processQueries(int[] queries, int m) {
        int[] res = new int[queries.length];
        int[] p = new int[m];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            p[i - 1] = i;
            map.put(i, i - 1);
        }
        for (int i = 0; i < queries.length; i++) {
            int qi = map.get(queries[i]);
            res[i] = qi;
            int originVal = p[qi];
            for (int j = qi - 1; j >= 0; j--) {
                p[j + 1] = p[j];
                map.put(p[j], j + 1);
            }
            p[0] = originVal;
            map.put(originVal, 0);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [3,1,2,0]
        System.out.println(s.processQueries(new int[] {3,1,2,1}, 5));
    }
}