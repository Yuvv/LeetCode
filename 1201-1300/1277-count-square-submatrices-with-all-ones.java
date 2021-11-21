/*
 * 1277-count-square-submatrices-with-all-ones.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/21
 */
public class Solution {
    public int countSquares(int[][] matrix) {
        int cnt = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    cnt++;
                    // expand & count
                    for (int k = 1; k < Math.min(matrix.length - i, matrix[i].length - j); k++) {
                        if (matrix[i + k][j + k] != 1) {
                            break;
                        }
                        boolean isBreak = false;
                        for (int m = 0; m < k; m++) {
                            if (matrix[i + k][j + m] != 1 || matrix[i + m][j + k] != 1) {
                                isBreak = true;
                                break;
                            }
                        }
                        if (isBreak) {
                            break;
                        }
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 15
        System.out.println(s.countSquares(new int[][] {
            {0,1,1,1},
            {1,1,1,1},
            {0,1,1,1}
        }));
        // 7
        System.out.println(s.countSquares(new int[][] {
            {1,0,1},
            {1,1,0},
            {1,1,0}
        }));
        // 19
        System.out.println(s.countSquares(new int[][] {
            {1,1,0,0,1},
            {1,0,1,1,1},
            {1,1,1,1,1},
            {1,0,1,0,1},
            {0,0,1,0,1}
        }));

    }
}