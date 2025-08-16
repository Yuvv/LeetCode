/**
 * 3643-flip-square-submatrix-vertically.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/08/16
 */
public class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int xb = x+k-1;
        while (x < xb) {
            for (int j = y; j < y+k; j++) {
                int tmp = grid[x][j];
                grid[x][j] = grid[xb][j];
                grid[xb][j] = tmp;
            }
            x++;
            xb--;
        }
        return grid;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[1,2,3,4],[13,14,15,8],[9,10,11,12],[5,6,7,16]]
        System.out.println(s.reverseSubmatrix(
            new int[][]{
                {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}
            },
            1, 0, 3
        ));
    }
}