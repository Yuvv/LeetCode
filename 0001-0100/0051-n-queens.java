import java.util.*;

/*
 * 0051-n-queens.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/03/07
 */
public class Solution {
    private List<List<String>> result;  // final result
    private int n;        // chessboard size
    private int[] rows;   // col of each row
    private int[] cols;   // col of each row
    private int[] hills;  // row + col = const
    private int[] dales;  // row - col = const


    public void removeQueen(int ri, int ci) {
        rows[ri] = -1;
        cols[ci] = -1;
        hills[ri + ci] = -1;
        dales[ri - ci + n - 1] = -1;
    }

    public void addQueen(int ri, int ci) {
        rows[ri] = ci;
        cols[ci] = 1;
        hills[ri + ci] = 1;
        dales[ri - ci + n - 1] = 1;
    }

    public boolean isUnderAttack(int ri, int ci) {
        if (rows[ri] >= 0 || cols[ci] >= 0) {
            return true;
        }
        if (hills[ri + ci] >= 0) {
            return true;
        }
        if (dales[ri - ci + n - 1] >= 0) {
            return true;
        }

        return false;
    }

    public List<String> buildSolution(int[] rows) {
        List<String> list = new ArrayList<>(rows.length);
        char[] chs = new char[rows.length];
        for (int ri : rows) {
            Arrays.fill(chs, '.');
            chs[ri] = 'Q';
            list.add(new String(chs));
        }
        return list;
    }

    public void solveN(int ri) {
        if (ri >= n) {
            this.result.add(buildSolution(rows));
            return;
        }
        for (int ci = 0; ci < this.n; ci++) {
            if (!isUnderAttack(ri, ci)) {
                addQueen(ri, ci);
                solveN(ri + 1);
                removeQueen(ri, ci);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
       this.result = new ArrayList<>(n);
        // init rows, cols, dales, hills;
        this.n = n;
        this.rows = new int[n];
        this.cols = new int[n];
        this.dales = new int[2 * n - 1]; // row - col = const
        this.hills = new int[2 * n - 1];  // row + col = const
        Arrays.fill(this.rows, -1);
        Arrays.fill(this.cols, -1);
        Arrays.fill(this.dales, -1);
        Arrays.fill(this.hills, -1);

        // solveN
        solveN(0);

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
        System.out.println(s.solveNQueens(4));
    }
}