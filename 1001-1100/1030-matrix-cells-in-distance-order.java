import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * 1030-matrix-cells-in-distance-order.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/28
 */
public class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        Map<Integer, List<int[]>> map = new TreeMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map.computeIfAbsent(Math.abs(i - rCenter) + Math.abs(j - cCenter), k -> new ArrayList<>())
                        .add(new int[] {i, j});
            }
        }

        int[][] res = new int[rows * cols][];
        int i = 0;
        for (List<int[]> list : map.values()) {
            for (int[] each : list) {
                res[i++] = each;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[0,0],[0,1]]
        System.out.println(Arrays.toString(s.allCellsDistOrder(1, 2, 0, 0)));
        // [[0,1],[0,0],[1,1],[1,0]]
        System.out.println(Arrays.toString(s.allCellsDistOrder(2, 2, 0, 1)));
        // [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
        System.out.println(Arrays.toString(s.allCellsDistOrder(2, 3, 1, 2)));
    }
}