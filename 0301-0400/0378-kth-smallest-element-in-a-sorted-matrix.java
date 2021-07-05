/*
 * 0378-kth-smallest-element-in-a-sorted-matrix.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/07/05
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int minVal = matrix[0][0];
        int maxVal = matrix[rows - 1][cols - 1];

        while (minVal < maxVal) {
            int mid = (minVal + maxVal) / 2;
            int cnt = this.getCount(matrix, mid);
            if (cnt < k) {
                minVal = mid + 1;
            } else {
                maxVal = mid;
            }
        }
        return maxVal;
    }

    public int getCount(int[][] matrix, int num) {
        int r = 0;
        int c = matrix[0].length - 1;
        int cnt = 0;
        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] <= num) {
                cnt += c + 1;
                r += 1;
            } else {
                c -= 1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 13
        int[][] matrix = new int[][{
            {1,5,9},
            {10,11,13},
            {12,13,15}
        };
        System.out.println(matrix, 8);
    }
}