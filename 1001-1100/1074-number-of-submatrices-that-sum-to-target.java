import java.util.*;

/*
 * 1074-number-of-submatrices-that-sum-to-target.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/18
 */
public class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        // get prefix sum
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                matrix[i][j] += matrix[i][j-1];
            }
        }
        // find result --> see: 0560
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                map.clear();
                map.put(0, 1);
                int cur = 0;
                for (int k = 0; k < matrix.length; k++) {
                    cur += matrix[k][j];
                    if (i > 0) {
                        cur -= matrix[k][i-1];
                    }
                    res += map.getOrDefault(cur - target, 0);
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.numSubmatrixSumTarget(
            new int[][] {{0,1,0}, {1,1,1}, {0,1,0}},
            0
        ));
        // 5
        System.out.println(s.numSubmatrixSumTarget(
            new int[][] {{1,-1}, {-1,1}},
            0
        ));

    }
}