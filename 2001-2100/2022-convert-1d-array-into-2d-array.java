/*
 * 2022-convert-1d-array-into-2d-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/10/08
 */
public class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][];
        }

        int[][] res = new int[m][];
        for (int i = 0; i < m; i++) {
            res[i] = new int[n];
            for (int j = 0; j < n; j++) {
                res[i][j] = original[i * n + j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[1,2],[3,4]]
        System.out.println(s.construct2DArray(new int[]{1, 2, 3, 4}, 2, 2));
        // [[1,2,3]]
        System.out.println(s.construct2DArray(new int[]{1, 2, 3}, 1, 3));
        // []
        System.out.println(s.construct2DArray(new int[]{1, 2}, 1, 1));
        // []
        System.out.println(s.construct2DArray(new int[]{3}, 1, 2));
    }
}