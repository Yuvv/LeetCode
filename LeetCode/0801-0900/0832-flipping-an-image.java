class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int tmp;
        int rowNum = A.length;
        int colNum = A[0].length;
        for (int i=0; i<rowNum; i++) {
            for (int j=0; j<Math.ceil(colNum / 2D); j++) {
                tmp = A[i][colNum - 1 - j];
                A[i][colNum - 1 - j] = 1 - A[i][j];
                A[i][j] = 1 - tmp;
            }
        }
        return A;
    }
}