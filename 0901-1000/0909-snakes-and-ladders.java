import java.util.*;
/**
 * 0909-snakes-and-ladders.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/05/31
 */
public class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] minRolls = new int[n * n + 1];
        Arrays.fill(minRolls, -1);
        LinkedList<Integer> queue = new LinkedList<>();
        minRolls[1] = 0;
        queue.offer(1);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == n * n) {
                return minRolls[current];
            }
            for (int next = current + 1; next <= Math.min(current + 6, n * n); next++) {
                int row = n - 1 - (next - 1) / n; // Calculate row index
                int col;
                if (row % 2 != n % 2) {
                    col = (next - 1) % n; // Calculate column index
                } else {
                    col = n - 1 - (next - 1) % n; // Calculate column index
                }
                int rn = board[row][col] == -1 ? next : board[row][col];
                if (minRolls[rn] < 0) {
                    minRolls[rn] = minRolls[current] + 1;
                    queue.offer(rn); // Just move to the next cell
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.snakesAndLadders(new int[][]{
                {2, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1},
        }));
        // 4
        System.out.println(s.snakesAndLadders(new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        }));
        // -1
        System.out.println(s.snakesAndLadders(new int[][]{
                {1, 1, -1}, {1, 1, 1}, {-1, 1, 1}
        }));
    }
}