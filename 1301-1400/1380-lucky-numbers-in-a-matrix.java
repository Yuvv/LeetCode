import java.util.*;

/*
 * 1380-lucky-numbers-in-a-matrix.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/10/22
 */
public class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int[] rowMin = new int[matrix.length];
        int[] colMax = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == 0) {
                    rowMin[i] = matrix[i][j];
                } else {
                    rowMin[i] = Math.min(rowMin[i], matrix[i][j]);
                }
                if (i == 0) {
                    colMax[j] = matrix[i][j];
                } else {
                    colMax[j] = Math.max(colMax[j], matrix[i][j]);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int val : rowMin) {
            set.add(val);
        }
        for (int val : colMax) {
            if (set.contains(val)) {
                return Collections.singletonList(val);
            }
        }

        return Collections.emptyList();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [15]
        System.out.println(s.luckyNumbers(new int[][] {
            {3, 7, 8},
            {9, 11, 13},
            {15, 18, 17}
        }));;
        // [12]
        System.out.println(s.luckyNumbers(new int[][] {
            {1, 10, 4, 2},
            {9, 3, 8, 7},
            {15, 16, 17, 12}
        }));
        // [7]
        System.out.println(s.luckyNumbers(new int[][] {
            {7, 8},
            {1, 2}
        }));
        // []
        System.out.println(s.luckyNumbers(new int[][] {
            {3, 6},
            {7, 1},
            {5, 2},
            {4, 8}
        }));
    }
}