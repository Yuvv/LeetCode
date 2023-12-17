/**
 * 2482-difference-between-ones-and-zeros-in-row-and-column
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/12/17
 */
public class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int nRow = grid.length;
        int nCol = grid[0].length;
        int[][] res = new int[nRow][nCol];
        int[] onesRow = new int[nRow];
        int[] onesCol = new int[nCol];
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                if (grid[i][j] == 1) {
                    onesRow[i] += 1;
                    onesCol[j] += 1;
                }
            }
        }

        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                res[i][j] = onesRow[i] + onesCol[j] - (nRow - onesRow[i]) - (nCol - onesCol[j]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[0,0,4],[0,0,4],[-2,-2,2]]
        System.out.println(s.onesMinusZeros(
                    new int[][]{{0,1,1},{1,0,1},{0,0,1}}
                    ));
        // [[5,5,5],[5,5,5]]
        System.out.println(s.onesMinusZeros(
                    new int[][]{{1,1,1},{1,1,1}}
                    ));
    }
}
