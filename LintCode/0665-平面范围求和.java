/**
 * 给一 二维矩阵,计算由左上角 (row1, col1) 和右下角 (row2, col2) 划定的矩形内元素和.
 * 1. 你可以假设矩阵不变
 * 2. 对函数 sumRegion 的调用次数有很多次
 * 3. 你可以假设 row1 ≤ row2 并且 col1 ≤ col2
 */
class NumMatrix {
    
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = new int[matrix.length][];
        for(int i=0; i<matrix.length; i++) {
            this.matrix[i] = matrix[i];
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i=row1; i<= row2; i++) {
            for (int j=col1; j<=col2; j++) {
                sum += this.matrix[i][j];
            }
        }
        
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */