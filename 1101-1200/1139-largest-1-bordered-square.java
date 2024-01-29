/**
 * 1139-largest-1-bordered-square.java
 *
 * @date 2024/1/29
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    private static int MOD = 10000;
    public int largest1BorderedSquare(int[][] grid) {
        int nRow = grid.length;
        int nCol = grid[0].length;
        int[][] prefixsum = new int[nRow][nCol];
        prefixsum[0][0] = grid[0][0] * MOD + grid[0][0];
        for (int i = 1; i < nRow; i++) {
            prefixsum[i][0] = (prefixsum[i-1][0]/MOD+grid[i][0])*MOD+grid[i][0];
        }
        for (int j = 1; j < nCol; j++) {
            prefixsum[0][j] = grid[0][j]*MOD + prefixsum[0][j-1]%MOD+grid[0][j];
        }
        // row prefix sum
        for (int i = 1; i < nRow; i++) {
            for (int j = 1; j < nCol; j++) {
                prefixsum[i][j] = prefixsum[i][j-1]%MOD + grid[i][j];
            }
        }
        // column prefix sum
        for (int j = 1; j < nCol; j++) {
            for (int i = 1; i < nRow; i++) {
                prefixsum[i][j] += (prefixsum[i-1][j]/MOD+grid[i][j])*MOD;
            }
        }

        //print2dArray(prefixsum);

        int max = 0;
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                max = Math.max(max, 1);
                for (int k = max; i+k < nRow && j+k < nCol; k++) {
                    if (grid[i+k][j+k] != 1) {
                        continue;
                    }
                    int top = prefixsum[i][j+k]%MOD - prefixsum[i][j]%MOD;
                    int down = prefixsum[i+k][j+k]%MOD - prefixsum[i+k][j]%MOD;
                    int left = prefixsum[i+k][j]/MOD - prefixsum[i][j]/MOD;
                    int right = prefixsum[i+k][j+k]/MOD - prefixsum[i][j+k]/MOD;
                    //System.out.println("top="+top + ", down=" + down + ", left=" + left + ", right=" + right);
                    if (top == k && down == k && left==k && right==k) {
                        max = k+1;
                    }
                }
            }
        }
        return max*max;
    }

    private void print2dArray(int[][] arr) {
        System.out.println("[");
        for (int[] aa : arr) {
            System.out.print("  ");
            System.out.print(java.util.Arrays.toString(aa));
            System.out.println(",\n");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 9
        System.out.println(s.largest1BorderedSquare(new int[][]{{1,1,1},{1,0,1},{1,1,1}}));
        // 1
        System.out.println(s.largest1BorderedSquare(new int[][]{{1,1,0,0}}));
    }
}
