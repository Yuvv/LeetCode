/**
 * 1267-count-servers-that-communicate.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/06/21
 */
public class Solution {
    public int countServers(int[][] grid) {
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && (rows[i] > 1 || cols[j] > 1)) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0
        System.out.println(s.countServers(new int[][]{
            {1, 0}, {0, 1}
        }));
        // 3
        System.out.println(s.countServers(new int[][]{
            {1, 0}, {1, 1}
        }));
        // 4
        System.out.println(s.countServers(new int[][]{
            {1, 1,0,0}, {0,0,1,0},{0,0,1,0},{0,0,0,1}
        }));
    }
}