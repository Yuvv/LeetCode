/**
 * 3239-minimum-number-of-flips-to-make-binary-grid-palindromic-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/08
 */
public class Solution {
    public int minFlips(int[][] grid) {
        // rows
        int rc = 0;
        for (int[] row : grid) {
            for (int i = 0; i < row.length/2; i++) {
                if (row[i] != row[row.length-1-i]) {
                    rc++;
                }
            }
        }
        // cols
        int cc = 0;
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length/2; j++) {
                if (grid[j][i] != grid[grid.length-1-j][i]) {
                    cc++;
                }
            }
        }
        return Math.min(cc, rc);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.minFlips(new int[][] {{1,0,0}, {0,0,0}, {0,0,1}}));
        // 1
        System.out.println(s.minFlips(new int[][] {{0,1}, {0,1}, {0,0}}));
        // 0
        System.out.println(s.minFlips(new int[][] {{1}, {0}}));
    }
}
