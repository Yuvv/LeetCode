/**
 * 2257-count-unguarded-cells-in-the-grid.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/11/21
 */
public class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        byte[][] matrix = new byte[m][n];
        int count = 0;
        for (int[] w : walls) {
            matrix[w[0]][w[1]] = '1';
            count++;
        }
        for (int[] w : guards) {
            matrix[w[0]][w[1]] = '1';
            count++;
        }
        for (int[] w : guards) {
            for (int i = w[0]-1; i >= 0; i--) {
                if (matrix[i][w[1]] == '1') {
                    break;
                }
                if (matrix[i][w[1]] == 0) {
                    matrix[i][w[1]] = '2';
                    count++;
                }
            }
            for (int i = w[0]+1; i < m; i++) {
                if (matrix[i][w[1]] == '1') {
                    break;
                }
                if (matrix[i][w[1]] == 0) {
                    matrix[i][w[1]] = '2';
                    count++;
                }
            }
            for (int j = w[1]-1; j >= 0; j--) {
                if (matrix[w[0]][j] == '1') {
                    break;
                }
                if (matrix[w[0]][j] == 0) {
                    matrix[w[0]][j] = '2';
                    count++;
                }
            }
            for (int j = w[1]+1; j < n; j++) {
                if (matrix[w[0]][j] == '1') {
                    break;
                }
                if (matrix[w[0]][j] == 0) {
                    matrix[w[0]][j] = '2';
                    count++;
                }
            }
        }
        return m*n-count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 7
        System.out.println(s.countUnguarded(
            4, 6,
            new int[][]{{0,0}, {1,1}, {2,3}},
            new int[][]{{0,1}, {2,2}, {1,4}}
        ));
        // 4
        System.out.println(s.countUnguarded(
            3, 3,
            new int[][]{{1,1}},
            new int[][]{{0,1}, {1,0}, {2,1}, {1,2}}
        ));
    }
}
