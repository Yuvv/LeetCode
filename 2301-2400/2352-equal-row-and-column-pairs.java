import java.util.*;

/*
 * 2352-equal-row-and-column-pairs.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/11/05
 */
public class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        if (n == 1) {
            return 1;
        }
        int nPairs = 0;
        Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(grid[i][0], k -> new HashMap<>())
                    .computeIfAbsent(grid[i][1], k -> new ArrayList<>())
                    .add(i);
        }
        for (int i = 0; i < n; i++) {
            Map<Integer, List<Integer>> mm = map.get(grid[0][i]);
            if (mm == null) {
                continue;
            }
            if (mm.containsKey(grid[1][i])) {
                for (int nRow : mm.get(grid[1][i])) {
                    boolean match = true;
                    for (int j = 2; j < n; j ++) {
                        if (grid[nRow][j] != grid[j][i]) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        nPairs++;
                    }
                }

            }
        }
        return nPairs;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.equalPairs(
            new int[][] {
                {3,1,2,2},
                {1,4,4,5},
                {2,4,2,2},
                {2,4,2,2}
            }
        ));
    }
}