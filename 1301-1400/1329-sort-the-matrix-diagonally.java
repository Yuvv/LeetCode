import java.util.*;

/*
 * 1329-sort-the-matrix-diagonally.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/27
 */
public class Solution {

    public void sortAndSet(int[][] mat, int x, int y) {
        int nRow = mat.length;
        int nCol = mat[0].length;

        int ii = x;
        int jj = y;
        List<Integer> list = new ArrayList<>();
        while (ii < nRow && jj < nCol) {
            list.add(mat[ii][jj]);
            ii++;
            jj++;
        }
        Collections.sort(list);
        int k = 0;
        ii = x;
        jj = y;
        while (ii < nRow && jj < nCol) {
            mat[ii][jj] = list.get(k);
            ii++;
            jj++;
            k++;
        }
    }

    public int[][] diagonalSort(int[][] mat) {
        int nRow = mat.length;
        int nCol = mat[0].length;

        int i = 0;
        int j;
        for (j = 0; j < nCol; j++) {
            sortAndSet(mat, i, j);
        }
        j = 0;
        for (i = 1; i < nRow; i++) {
            sortAndSet(mat, i, j);
        }
        return mat;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
        System.out.println(Arrays.deepToString(s.diagonalSort(
            new int[][] {
                {3, 3, 1, 1},
                {2, 2, 1, 2},
                {1, 1, 1, 2}
            }
        )));
    }
}