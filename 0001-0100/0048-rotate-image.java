class Solution {

    /**
     * 翻转90度
     * https://leetcode.com/problems/rotate-image/
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int tmp;
        // 水平翻转
        for (int i = 0; i < len; i++) {
            for (int j = 0, k = len - 1; j < k; j++, k--) {
                tmp = matrix[i][k];
                matrix[i][k] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // 对角"/"翻转
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0, k = len - 1 - i; j < k; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][len - 1 - i];
                matrix[len - 1 - j][len - 1 - i] = tmp;
            }
        }
    }
}