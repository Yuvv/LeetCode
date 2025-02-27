import java.util.Arrays;
/**
 * 3446-sort-matrix-by-diagonals.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/02/27
 */
public class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int[] tmp = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            int k = 0;
            int r = i, c = 0;
            while (r < grid.length && c < grid.length) {
                tmp[k++] = grid[r++][c++];
            }
            Arrays.sort(tmp, 0, k);
            r = i;
            c = 0;
            while (r < grid.length && c < grid.length) {
                grid[r++][c++] = tmp[--k];
            }
        }
        for (int i = 1; i < grid.length; i++) {
            int k = 0;
            int r = 0, c = i;
            while (r < grid.length && c < grid.length) {
                tmp[k++] = grid[r++][c++];
            }
            Arrays.sort(tmp, 0, k);
            r = 0;
            c = i;
            k = 0;
            while (r < grid.length && c < grid.length) {
                grid[r++][c++] = tmp[k++];
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[8,2,3],[9,6,7],[4,5,1]]
        System.out.println(s.sortMatrix(new int[][]{{1, 7, 3}, {9, 8, 2}, {4, 5, 6}}));
    }
}
