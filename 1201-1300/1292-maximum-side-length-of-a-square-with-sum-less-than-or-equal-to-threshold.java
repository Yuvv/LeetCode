/*
 * 1292-maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/23
 */
public class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        boolean hasResult = mat[0][0] <= threshold;
        int[][] matsum = new int[mat.length][mat[0].length];
        // init first cell
        matsum[0][0] = mat[0][0];
        // init first row
        for (int i = 1; i < mat[0].length; i++) {
            matsum[0][i] = matsum[0][i - 1] + mat[0][i];
            if (mat[0][i] <= threshold) {
                hasResult = true;
            }
        }
        // init first col
        for (int i = 1; i < mat.length; i++) {
            matsum[i][0] = matsum[i - 1][0] + mat[i][0];
            if (mat[i][0] <= threshold) {
                hasResult = true;
            }
        }
        // set others
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[i].length; j++) {
                matsum[i][j] = matsum[i - 1][j] + matsum[i][j - 1] - matsum[i - 1][j - 1] + mat[i][j];
                if (mat[i][j] <= threshold) {
                    hasResult = true;
                }
            }
        }
        if (!hasResult) {
            return 0;
        }

        // find result
        int lo = 1;
        int hi = Math.min(mat.length, mat[0].length);
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (mi == lo) {
                mi++;
            }
            if (isOk(matsum, threshold, mi)) {
                lo = mi;
            } else {
                hi = mi - 1;
            }
        }

        return lo;
    }

    public boolean isOk(int[][] matsum, int threshold, int sideLen) {
        for (int i = sideLen - 1; i < matsum.length; i++) {
            for (int j = sideLen - 1; j < matsum[i].length; j++) {
                int sum = matsum[i][j];
                int x = i - sideLen;
                int y = j - sideLen;
                if (x >= 0) {
                    sum -= matsum[x][j];
                }
                if (y >= 0) {
                    sum -= matsum[i][y];
                }
                if (x >= 0 && y >= 0) {
                    sum += matsum[x][y];
                }
                if (sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.maxSideLength(
            new int[][] {
                {1,1,3,2,4,3,2},
                {1,1,3,2,4,3,2},
                {1,1,3,2,4,3,2}
            },
            4
        ));
        // 3
        System.out.println(s.maxSideLength(
            new int[][] {
                {1,1,3,2,4,3,2},
                {1,1,3,2,4,3,2},
                {1,1,3,2,4,3,2},
                {1,1,3,2,4,3,2},
                {1,1,3,2,4,3,2}
            },
            27
        ));
    }
}