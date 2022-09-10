/*
 * 1975-maximum-matrix-sum.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/09/10
 */
public class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0L;
        int minusCount = 0;
        int min = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int val : row) {
                if (val < 0) {
                    val = -val;
                    minusCount++;
                }
                sum += val;
                if (val < min) {
                    min = val;
                }
            }
        }
        if (minusCount % 2 == 0) {
            return sum;
        } else {
            return sum - 2 * min;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.maxMatrixSum(
            new int[][] {
                {1, -1}, {-1, 1}
            }
        ));
        // 16
        System.out.println(s.maxMatrixSum(
            new int[][] {
                {1, 2, 3}, {-1, -2, -3}, {1, 2, 3}
            }
        ));
        // 15
        System.out.println(s.maxMatrixSum(
            new int[][] {
                {-1, 0, -1}, {-2, 1, 3}, {3, 2, 2}
            }
        ));
    }
}