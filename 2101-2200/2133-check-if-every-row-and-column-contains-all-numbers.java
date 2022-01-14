import java.util.*;

/*
 * 2133-check-if-every-row-and-column-contains-all-numbers.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/14
 */
public class Solution {
    public boolean checkValid(int[][] matrix) {
        Set<Integer> set = new HashSet<>();
        // rows
        for (int i = 0; i < matrix.length; i++) {
            set.clear();
            for (int j = 0; j < matrix.length; j++) {
                set.add(matrix[i][j]);
            }
            if (set.size() != matrix.length) {
                return false;
            }
        }
        // cols
        for (int i = 0; i < matrix.length; i++) {
            set.clear();
            for (int j = 0; j < matrix.length; j++) {
                set.add(matrix[j][i]);
            }
            if (set.size() != matrix.length) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.checkValid(new int[][] {
            {1,2,3},
            {3,1,2},
            {2,3,1}
        }));
        // false
        System.out.println(s.checkValid(new int[][] {
            {1,1,1},
            {1,2,3},
            {1,2,3}
        }));
    }
}