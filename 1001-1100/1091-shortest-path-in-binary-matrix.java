import java.util.*;

/*
 * 1091-shortest-path-in-binary-matrix.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/16
 */
public class Solution {
    private Map<String, Integer> CACHE_MAP;

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) {
            return -1;
        }
        this.CACHE_MAP = new HashMap<>(grid.length);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[2]));
        pq.add(new int[] {0, 0, 1});
        CACHE_MAP.put("0,0", 1);

        while (!pq.isEmpty()) {
            int[] ele = pq.poll();
            int i = ele[0];
            int j = ele[1];
            int v = ele[2];
            if (i == grid.length - 1 && j == grid.length - 1) {
                // we find it
                return v;
            }

            if (i > 0) {
                // (i-1, j)
                if (grid[i - 1][j] == 0) {
                    if (checkAndPut(i - 1, j, v + 1)) {
                        pq.add(new int[] {i - 1, j, v + 1});
                    }
                }
                // (i-1, j-1)
                if (j > 0 && grid[i-1][j-1] == 0) {
                    if (checkAndPut(i-1, j-1, v+1)) {
                        pq.add(new int[] {i-1, j-1, v+1});
                    }
                }
                // (i-1, j+1)
                if (j < grid.length - 1 && grid[i-1][j+1] == 0) {
                    if (checkAndPut(i-1, j+1, v+1)) {
                        pq.add(new int[] {i-1, j+1, v+1});
                    }
                }
            }
            // (i, j-1)
            if (j > 0 && grid[i][j-1] == 0) {
                if (checkAndPut(i, j-1, v+1)) {
                    pq.add(new int[] {i, j-1, v+1});
                }
            }
            // (i, j+1)
            if (j < grid.length - 1 && grid[i][j+1] == 0) {
                if (checkAndPut(i, j+1, v+1)) {
                    pq.add(new int[] {i, j+1, v+1});
                }
            }
            if (i < grid.length - 1) {
                // (i+1, j)
                if (grid[i+1][j] == 0) {
                    if (checkAndPut(i+1, j, v + 1)) {
                        pq.add(new int[] {i+1, j, v + 1});
                    }
                }
                // (i+1, j-1)
                if (j > 0 && grid[i+1][j-1] == 0) {
                    if (checkAndPut(i+1, j-1, v+1)) {
                        pq.add(new int[] {i+1, j-1, v+1});
                    }
                }
                // (i+1, j+1)
                if (j < grid.length - 1 && grid[i+1][j+1] == 0) {
                    if (checkAndPut(i+1, j+1, v+1)) {
                        pq.add(new int[] {i+1, j+1, v+1});
                    }
                }
            }
        }
        return -1;
    }

    public boolean checkAndPut(int i, int j, int v) {
        String key = i + "," + j;
        if (CACHE_MAP.getOrDefault(key, Integer.MAX_VALUE) > v) {
            CACHE_MAP.put(key, v);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.shortestPathBinaryMatrix(
            new int[][] {{0,1}, {1,0}}
        ));
        // 4
        System.out.println(s.shortestPathBinaryMatrix(
            new int[][] {{0,0,0},{1,1,0},{1,1,0}}
        ));
        // -1
        System.out.println(s.shortestPathBinaryMatrix(
            new int[][] {{1,0,0},{1,1,0},{1,1,0}}
        ));
    }
}