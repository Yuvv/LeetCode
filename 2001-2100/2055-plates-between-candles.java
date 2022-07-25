/*
 * 2055-plates-between-candles.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/25
 */
public class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] prefixSumArray = new int[s.length()];
        int[][] candleIndex = new int[s.length()][2];
        int prevIdx = -1;
        int prefixSum = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                prefixSum++;
            } else {
                prevIdx = i;
            }
            prefixSumArray[i] = prefixSum;
            candleIndex[i][1] = prevIdx;
        }
        prevIdx = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '|') {
                prevIdx = i;
            }
            candleIndex[i][0] = prevIdx;
        }

        int[] res = new int[queries.length];
        int i = 0;
        for (int[] query : queries) {
            int left = candleIndex[query[0]][0];
            int right = candleIndex[query[1]][1];
            if (left >= 0 && right < s.length() && left <= right) {
                res[i] = prefixSumArray[right] - prefixSumArray[left];
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [2,3]
        System.out.println(java.util.Arrays.toString(
            s.platesBetweenCandles("**|**|***|", new int[][]{{2,5},{5,9}})
        ));
        // [9,0,0,0,0]
        System.out.println(java.util.Arrays.toString(
            s.platesBetweenCandles(
                "***|**|*****|**||**|*",
                 new int[][]{{1,17},{4,5},{14,17},{5,11},{15,16}}
            )
        ));
    }
}