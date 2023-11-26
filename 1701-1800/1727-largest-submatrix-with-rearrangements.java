import java.util.Arrays;

/**
 * 1727-largest-submatrix-with-rearrangements
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/11/26
 */
public class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // for each column, calculate column consecutive ones
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < m; i++) {
                if (matrix[i][j] > 0) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }
        // for each row, sort it & fit largest submatrix
        int max = 0;
        for (int[] row : matrix) {
            Arrays.sort(row);
            for (int j = n - 1, k = 1; j >= 0 && row[j] > 0; j--, k++) {
                max = Math.max(max, row[j] * k);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.largestSubmatrix(new int[][] {
                { 0, 0, 1 }, { 1, 1, 1 }, { 1, 0, 1 }
        }));
        // 3
        System.out.println(s.largestSubmatrix(new int[][] {
                { 1, 0, 1, 0, 1 }
        }));
        // 2
        System.out.println(s.largestSubmatrix(new int[][] {
                { 1, 1, 0 }, { 1, 0, 1 }
        }));
    }
}
