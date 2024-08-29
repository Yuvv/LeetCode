/**
 * 2658-maximum-number-of-fish-in-a-grid.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/29
 */
public class Solution {
    public int findMaxFish(int[][] grid) {
        boolean[][] flags = new boolean[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0 || flags[i][j]) {
                    continue;
                }
                max = Math.max(max, dfs(grid, flags, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] grid, boolean[][] flags, int i, int j) {
        if (flags[i][j] || grid[i][j] == 0) {
            return 0;
        }
        int cnt = grid[i][j];
        flags[i][j] = true;
        if (i > 0) {
            cnt += dfs(grid, flags, i-1, j);
        }
        if (i < grid.length-1) {
            cnt += dfs(grid, flags, i+1, j);
        }
        if (j > 0) {
            cnt += dfs(grid, flags, i, j-1);
        }
        if (j < grid[i].length-1) {
            cnt += dfs(grid, flags, i, j+1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 7
        System.out.println(s.findMaxFish(
            new int[][] {{0,2,1,0}, {4,0,0,3}, {1,0,0,4}, {0,3,2,0}}
        ));
        // 1
        System.out.println(s.findMaxFish(
            new int[][] {{1,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,1}}
        ));
    }
}
