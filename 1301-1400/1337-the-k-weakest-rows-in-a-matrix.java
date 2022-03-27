import java.util.*;

/*
 * 1337-the-k-weakest-rows-in-a-matrix.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/27
 */
public class Solution {

    int getValue(int[] row) {
        int i = 0, j = row.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (row[mid] == 1) {
                i = mid + 1;
            } else if (row[mid] == 0) {
                j = mid - 1;
            }
        }
        if (row[i] == 0) {
            return i;
        }
        return i + 1;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] arr = new int[mat.length][2];
        int lastValue = Integer.MAX_VALUE;
        for (int i = 0; i < mat.length; i++) {
            int[] row = mat[i];
            int curValue = getValue(row);
            arr[i] = new int[] {i, curValue};
            lastValue = curValue;
        }

        Arrays.sort(arr, Comparator.comparingInt(e -> ((int[]) e)[1]).thenComparing(e -> ((int[]) e)[0]));

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i][0];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [2,0,3]
        System.out.println(Arrays.toString(
            s.kWeakestRows(
                new int[][] {
                    {1,1,0,0,0},
                    {1,1,1,1,0},
                    {1,0,0,0,0},
                    {1,1,0,0,0},
                    {1,1,1,1,1}
                },
                3
            )
        ));
        // [0,2]
        System.out.println(Arrays.toString(
            s.kWeakestRows(
                new int[][] {
                    {1,0,0,0},
                    {1,1,1,1},
                    {1,0,0,0,0},
                    {1,1,0,0,0},
                    {1,1,1,1,1}
                },
                2
            )
        ));
    }
}