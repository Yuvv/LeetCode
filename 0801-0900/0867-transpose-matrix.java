class Solution {
    /**
     * 矩阵转秩
     * https://leetcode.com/problems/transpose-matrix/
     *
     * @param A 矩阵
     * @return 转秩后结果
     */
    public int[][] transpose(int[][] A) {
        if (A.length == 0) {
            return A;
        }
        int row = A.length, col = A[0].length;
        int[][] result = new int[col][];
        for (int i = 0; i < col; i++) {
            result[i] = new int[row];
            for (int j = 0; j < row; j++) {
                result[i][j] = A[j][i];
            }
        }
        return A;
    }
}