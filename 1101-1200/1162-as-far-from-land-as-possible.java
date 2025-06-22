import java.util.LinkedList;
/**
 * 1162-as-far-from-land-as-possible.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/06/22
 */
public class Solution {
    public int maxDistance(int[][] grid) {
        int depth = -1;
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        if (queue.isEmpty() || queue.size() == grid.length * grid[0].length) {
            return -1; // special case
        }
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            while (size-- > 0) {
                int[] pt = queue.pollFirst();
                int pi = pt[0];
                int pj = pt[1];
                for (int[] dir : dirs) {
                    int ni = pi + dir[0];
                    int nj = pj + dir[1];
                    if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == 0) {
                        grid[ni][nj] = 1;
                        queue.add(new int[]{ni, nj});
                    }
                }
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.maxDistance(new int[][]{
            {1, 0, 1},
            {0, 0, 0},
            {1, 0, 1}
        }));
        // 4
        System.out.println(s.maxDistance(new int[][]{
            {1, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        }));
    }
}