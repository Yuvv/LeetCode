import java.util.Set;
import java.util.HashSet;

/*
 * 1034-coloring-a-border.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/25
 */
public class Solution {

    private Set<String> cache;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        cache = new HashSet<>();

        expandAndSet(grid, row, col, grid[row][col], color);

        return grid;
    }

    public void expandAndSet(int[][] grid, int row, int col,
                             int originColor, int color) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return;
        }
        if (grid[row][col] != originColor) {
            return;
        }
        String key = row + "," + col;
        if (cache.contains(key)) {
            return;
        }
        cache.add(key);
        // up
        if (row > 0) {
            if (grid[row - 1][col] == originColor) {
                expandAndSet(grid, row - 1, col, originColor, color);
            } else if (!cache.contains((row - 1) + "," + col)) {
                // upper one is not origin color, is border
                grid[row][col] = color;
            }
        } else if (grid[row][col] == originColor) {
            // row = 0, is border
            grid[row][col] = color;
        }
        // down
        if (row < grid.length - 1) {
            if (grid[row + 1][col] == originColor) {
                expandAndSet(grid, row + 1, col, originColor, color);
            } else if (!cache.contains((row + 1) + "," + col)) {
                // bottom one is not origin color, is border
                grid[row][col] = color;
            }
        } else if (grid[row][col] == originColor) {
            // row = nRows - 1, is border
            grid[row][col] = color;
        }
        // left
        if (col > 0) {
            if (grid[row][col - 1] == originColor) {
                expandAndSet(grid, row, col - 1, originColor, color);
            } else if (!cache.contains(row + "," + (col - 1))) {
                // left one is not origin color, is border
                grid[row][col] = color;
            }
        } else if (grid[row][col] == originColor) {
            // col = 0, is border
            grid[row][col] = color;
        }
        // right
        if (col < grid[0].length - 1) {
            if (grid[row][col + 1] == originColor) {
                expandAndSet(grid, row, col + 1, originColor, color);
            } else if (!cache.contains(row + "," + (col + 1))) {
                // right one is not origin color, is border
                grid[row][col] = color;
            }
        } else if (grid[row][col] == originColor) {
            // col = nCols - 1, is border
            grid[row][col] = color;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[3,3],[3,2]]
        System.out.println(s.colorBorder(new int[][] {{1,1},{1,2}}, 0, 0, 3));
        // [[1,3,3],[2,3,3]]
        System.out.println(s.colorBorder(new int[][] {{1,2,2},{2,3,2}}, 0, 1, 3));
        // [[2,2,2],[2,1,2],[2,2,2]]
        System.out.println(s.colorBorder(new int[][] {{1,1,1},{1,1,1},{1,1,1}}, 1, 1, 2));
    }
}