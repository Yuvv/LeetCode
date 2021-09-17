import java.util.Set;
import java.util.HashSet;

/*
 * 0289-game-of-life.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/17
 */
public class Solution {

    public void gameOfLife(int[][] board) {
        Set<Integer> changed = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // match rules
                int live = 0;
                int idx;
                if (i > 0) {
                    if (j > 0) {
                        // up-left
                        if (isLive(board, i - 1, j - 1, changed)) {
                            live++;
                        }
                    }
                    // up
                    if (isLive(board, i - 1, j, changed)) {
                        live++;
                    }
                    if (j < board[i].length - 1) {
                        // up-right
                        if (isLive(board, i - 1, j + 1, changed)) {
                            live++;
                        }
                    }
                }
                if (j > 0) {
                    //left
                    if (isLive(board, i, j - 1, changed)) {
                        live++;
                    }
                }
                if (j < board[i].length - 1) {
                    // right
                    if (isLive(board, i, j + 1, changed)) {
                        live++;
                    }
                }
                if (i < board.length - 1) {
                    if (j > 0) {
                        // bottom-left
                        if (isLive(board, i + 1, j - 1, changed)) {
                            live++;
                        }
                    }
                    // bottom
                    if (isLive(board, i + 1, j, changed)) {
                        live++;
                    }
                    if (j < board[i].length - 1) {
                        // bottom-right
                        if (isLive(board, i + 1, j + 1, changed)) {
                            live++;
                        }
                    }
                }
                idx = i * board[i].length + j;
                if (board[i][j] == 1) {
                    // live cell
                    if (live < 2 || live > 3) {
                        board[i][j] = 0;
                        changed.add(idx);
                    }
                } else {
                    // dead cell
                    if (live == 3) {
                        board[i][j] = 1;
                        changed.add(idx);
                    }
                }
            }
        }
    }

    boolean isLive(int[][] board, int i, int j, Set<Integer> changed) {
        int idx = i * board[i].length + j;
        if (board[i][j] == 1 && !changed.contains(idx)
                || board[i][j] == 0 && changed.contains(idx)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[1,1,0,0,0,0,1],[0,0,0,1,0,0,1],[0,0,0,0,0,0,1],[1,1,0,0,0,0,0]]
        s.gameOfLife(new int[][] {
            {0, 1, 0, 0, 1, 1, 0},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 0, 0, 0, 0, 1},
            {1, 1, 0, 0, 1, 0, 0}
        });
        // [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
        s.gameOfLife(new int[][] {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        });
        // [[1,1],[1,1]]
        s.gameOfLife(new int[][] {
            {1, 1},
            {1, 0},
        });
    }
}