import java.util.*;

/*
 * 0646-maximum-length-of-pair-chain.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/08/26
 */
public class Solution {
    public int findLongestChain(int[][] pairs) {
        TreeMap<Integer, int[]> map = new TreeMap<>();
        for (int[] p : pairs) {
            int[] v = map.getOrDefault(p[0], new int[]{p[1], 0});
            v[0] = Math.min(v[0], p[1]);
            map.put(p[0], v);
        }

        int i = 0;
        int[] points = new int[map.size()];
        for (Integer key : map.keySet()) {
            points[i++] = key;
        }
        map.lastEntry().getValue()[1] = 1;
        int maxLen = 1;
        for (i = points.length - 2; i >= 0; i--) {
            Map.Entry<Integer, int[]> entry = map.higherEntry(map.get(points[i])[0]);
            int curMax = 1;
            if (entry != null) {
                curMax += entry.getValue()[1];
            }
            int max = Math.max(curMax, map.get(points[i+1])[1]);
            maxLen = Math.max(maxLen, max);
            map.get(points[i])[1] = max;
        }
        return maxLen;
    }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.findLongestChain(
            new int[][]{{1,2},{2,3},{3,4}}
        ));
        // 3
        System.out.println(s.findLongestChain(
            new int[][]{{1,2},{7,8},{4,5}}
        ));
    }
}