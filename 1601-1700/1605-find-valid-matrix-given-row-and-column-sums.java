/**
 * 1605-find-valid-matrix-given-row-and-column-sums.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/20
 */
public class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] res = new int[rowSum.length][colSum.length];
        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                res[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= res[i][j];
                colSum[j] -= res[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[3,0], [1,7]]
        System.out.println(s.restoreMatrix(new int[]{3,8}, new int[]{4,7}));
        // [[0,5,0],[6,1,0],[2,0,8]]
        System.out.println(s.restoreMatrix(new int[]{5,7,10}, new int[]{8,6,8}));
    }
}
