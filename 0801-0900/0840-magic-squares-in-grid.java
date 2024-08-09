/**
 * 0840-magic-squares-in-grid.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/09
 */
public class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int[][] gcsum = new int[grid.length+1][grid[0].length+1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                gcsum[i+1][j+1] = gcsum[i][j+1] + gcsum[i+1][j] - gcsum[i][j] + grid[i][j];
            }
        }
        //
        int cnt = 0;
        for (int i = 2; i < grid.length; i++) {
            for (int j = 2; j < grid[i].length; j++) {
                int sum = gcsum[i+1][j+1] - gcsum[i-2][j+1] - gcsum[i+1][j-2] + gcsum[i-2][j-2];
                if (sum == 45) {
                    if (check(grid, i, j)) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    private boolean check(int[][] grid, int i, int j) {
        int row1 = grid[i-2][j-2] + grid[i-2][j-1] + grid[i-2][j];
        if (grid[i-1][j-2] + grid[i-1][j-1] + grid[i-1][j] != row1) { // row2
            return false;
        }
        if (grid[i][j-2] + grid[i][j-1] + grid[i][j] != row1) { // row3
            return false;
        }
        if (grid[i-2][j-2] + grid[i-1][j-2] + grid[i][j-2] != row1) { // col1
            return false;
        }
        if (grid[i-2][j-1] + grid[i-1][j-1] + grid[i][j-1] != row1) { // col2
            return false;
        }
        if (grid[i-2][j] + grid[i-1][j] + grid[i][j] != row1) { // col3
            return false;
        }
        if (grid[i-2][j-2] + grid[i-1][j-1] + grid[i][j] != row1) { // dia
            return false;
        }
        if (grid[i-2][j] + grid[i-1][j-1] + grid[i][j-2] != row1) { // r-ria
            return false;
        }
        boolean[] seen = new boolean[10];
        for (int ii = i-2; ii <= i; ii++) {
            for (int jj = j-2; jj <= j; jj++) {
                if (grid[ii][jj] <= 0 || grid[ii][jj] > 9) {
                    return false;
                }
                if (seen[grid[ii][jj]]) {
                    return false;
                }
                seen[grid[ii][jj]] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.numMagicSquaresInside(new int[][] {
            {4,3,8,4}, {9,5,1,9}, {2,7,6,2}
        }));
        // 0
        System.out.println(s.numMagicSquaresInside(new int[][] {
            {8}
        }));
    }
}
