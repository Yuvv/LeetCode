import java.util.Map;
import java.util.HashMap;

/*
 * 0931-minimum-falling-path-sum.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/28
 */
public class Solution {
    private Map<Integer, Map<Integer, Integer>> cacheMap;
    public int minFallingPathSum(int[][] matrix) {
        cacheMap = new HashMap<>(matrix.length);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            min = Math.min(min, getMinSum(matrix, 0, i));
        }
        return min;
    }

    public int getMinSum(int[][] matrix, int row, int col) {
        if (cacheMap.containsKey(row) && cacheMap.get(row).containsKey(col)) {
            return cacheMap.get(row).get(col);
        }
        if (row >= matrix.length) {
            return 0;
        }

        int sum = Integer.MAX_VALUE;
        if (col > 0) {
            sum = Math.min(sum, getMinSum(matrix, row + 1, col - 1));
        }
        sum = Math.min(sum, getMinSum(matrix, row + 1, col));
        if (col < matrix[0].length - 1) {
            sum = Math.min(sum, getMinSum(matrix, row + 1, col + 1));
        }

        sum += matrix[row][col];
        cacheMap.computeIfAbsent(row, k -> new HashMap<>()).put(col, sum);
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 13
        System.out.println(s.minFallingPathSum(new int[][]{{2,1,3},{6,5,4},{7,8,9}}));
        // -59
        System.out.println(s.minFallingPathSum(new int[][]{{-19,57},{-40,-5}}));
        // -48
        System.out.println(s.minFallingPathSum(new int[][]{{-48}}));
    }
}