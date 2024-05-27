import java.util.*;

/**
 * 3160-find-the-number-of-distinct-colors-among-the-balls.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/05/27
 */
public class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] res = new int[queries.length];
        Map<Integer, Integer> ballColor = new HashMap<>();
        Map<Integer, Integer> colorCnt = new HashMap<>(); // color -> count
        int i = 0;
        for (int[] q : queries) {
            Integer originColor = ballColor.get(q[0]);
            if (originColor != null) {
                Integer originCount = colorCnt.get(originColor);
                if (originCount != null) {
                    originCount--;
                    if (originCount == 0) {
                        colorCnt.remove(originColor);
                    } else {
                        colorCnt.put(originColor, originCount);
                    }
                }
            }
            ballColor.put(q[0], q[1]);
            colorCnt.put(q[1], colorCnt.getOrDefault(q[1], 0) + 1);
            res[i] = colorCnt.size();
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,2,2,3]
        System.out.println(java.util.Arrays.toString(s.queryResults(
            4, new int[][]{{1,4},{2,5},{1,3},{3,4}}
        )));
    }
}