/*
 * 0304-range-sum-query-2d-immutable.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/14
 */
class NumMatrix {

    private int[][] cumMatix;

    public NumMatrix(int[][] matrix) {
        cumMatix = matrix;
        for (int i = 0; i < cumMatix.length; i++) {
            for (int j = 0; j < cumMatix[i].length; j++) {
                if (i > 0) {
                    cumMatix[i][j] += cumMatix[i - 1][j];
                }
                if (j > 0) {
                    cumMatix[i][j] += cumMatix[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    cumMatix[i][j] -= cumMatix[i - 1][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = cumMatix[row2][col2];
        if (row1 > 0) {
            res -= cumMatix[row1 - 1][col2];
        }
        if (col1 > 0) {
            res -= cumMatix[row2][col1 -1];
        }
        if (row1 > 0 && col1 > 0) {
            res += cumMatix[row1 - 1][col1 - 1];
        }
        return res;
    }

}

public class Solution {

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][] {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        });
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // return 8 (i.e sum of the red rectangle)
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // return 11 (i.e sum of the green rectangle)
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // return 12 (i.e sum of the blue rectangle)
    }
}
