/*
 * 0861-score-after-flipping-matrix.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/11
 */
public class Solution {
    private int getMask(int len) {
        int mask = 0;
        while (len > 0) {
            mask <<= 1;
            mask |= 1;

            len--;
        }
        return mask;
    }

    public int matrixScore(int[][] grid) {
        int rowMask = getMask(grid[0].length);
        for (int[] row : grid) {
            int rowVal = 0;
            for (int i = 0; i < row.length; i++) {
                rowVal <<= 1;
                rowVal |= row[i];
            }
            if (((~rowVal) & rowMask) > rowVal) {
                for (int i = 0; i < row.length; i++) {
                    row[i] = 1 - row[i];
                }
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            int nOne = 0;
            int nZero = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 0) {
                    nZero++;
                } else {
                    nOne++;
                }
            }
            if (nOne < nZero) {
                for (int j = 0; j < grid.length; j++) {
                    grid[j][i] = 1 - grid[j][i];
                }
            }
        }

        int sum = 0;
        for (int[] row : grid) {
            int rowVal = 0;
            for (int i = 0; i < row.length; i++) {
                rowVal <<= 1;
                rowVal |= row[i];
            }
            sum += rowVal;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 39
        System.out.println(s.matrixScore(new int[][] {
            {0,0,1,1}, {1,0,1,0}, {1,1,0,0}
        }));
        // 38
        System.out.println(s.matrixScore(new int[][] {
            {1,0,1,1}, {1,0,1,0}, {1,1,0,0}
        }));
        // 1
        System.out.println(s.matrixScore(new int[][] {
            {0}
        }));
    }
}