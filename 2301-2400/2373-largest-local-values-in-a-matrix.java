/*
 * 2373-largest-local-values-in-a-matrix.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/08/13
 */
public class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] res = new int[grid.length-2][grid.length-2];
        for (int i = 1; i < grid.length-1; i++) {
            for (int j = 1; j < grid.length-1; j++) {
                // get max
                int max = grid[i][j];
                for (int ii = i-1; ii <= i+1; ii++) {
                    for (int jj = j-1; jj <= j+1; jj++) {
                        max = Math.max(max, grid[ii][jj]);
                    }
                }
                res[i-1][j-1]= max;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[9,9],[8,6]]
        System.out.println(java.util.Arrays.toString(
            s.largestLocal(new int[][]{
                {9,9,8,1}, {5,6,2,6}, {8,2,6,4}, {6,2,2,2}
            })
        ));
    }
}