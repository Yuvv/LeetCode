/*
 * 0529-minesweeper.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/12
 */
public class Solution {
    // M - unrevealed mine
    // E - unrevealed empty square
    // B - revealed blank square
    // [1.8] - mine count
    // X - revealed mine
    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0];
        int c = click[1];
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
        } else if (board[r][c] == 'E') {
            updateBoard(board, r, c);
        }

        return board;
    }

    public void updateBoard(char[][] board, int r, int c) {
        if (board[r][c] != 'E') {
            return;
        }
        board[r][c] = getSquareResult(board, r, c);
        if (board[r][c] == 'B') {
            if (r > 0) {
                // top
                updateBoard(board, r - 1, c);
                if (c > 0) {
                    // top-left
                    updateBoard(board, r - 1, c - 1);
                }
                if (c < board[0].length - 1) {
                    // top-right
                    updateBoard(board, r - 1, c + 1);
                }
            }
            if (r < board.length - 1) {
                // bottom
                updateBoard(board, r + 1, c);
                if (c > 0) {
                    // bottom-left
                    updateBoard(board, r + 1, c - 1);
                }
                if (c < board[0].length - 1) {
                    // bottom-right
                    updateBoard(board, r + 1, c + 1);
                }
            }
            if (c > 0) {
                // left
                updateBoard(board, r, c - 1);
            }
            if (c < board[0].length - 1) {
                // right
                updateBoard(board, r, c + 1);
            }
        }
    }

    public char getSquareResult(char[][] board, int r, int c) {
        int count = 0;
        if (r > 0) {
            if (board[r - 1][c] == 'M') {
                // top
                count++;
            }
            if (c > 0) {
                if (board[r - 1][c - 1] == 'M') {
                    // top-left
                    count++;
                }
            }
            if (c < board[0].length - 1) {
                if (board[r - 1][c + 1] == 'M') {
                    // top-right
                    count++;
                }
            }
        }
        if (r < board.length - 1) {
            if (board[r + 1][c] == 'M') {
                // bottom
                count++;
            }
            if (c > 0) {
                if (board[r + 1][c - 1] == 'M') {
                    // bottom-left
                    count++;
                }
            }
            if (c < board[0].length - 1) {
                if (board[r + 1][c + 1] == 'M') {
                    // bottom-right
                    count++;
                }
            }
        }
        if (c > 0) {
            if (board[r][c - 1] == 'M') {
                // left
                count++;
            }
        }
        if (c < board[0].length - 1) {
            if (board[r][c + 1] == 'M') {
                // right
                count++;
            }
        }
        // final result
        if (count == 0) {
            return 'B';
        } else {
            return (char)('0' + count);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [["B","1","E","1","B"],
        //  ["B","1","M","1","B"],
        //  ["B","1","1","1","B"],
        //  ["B","B","B","B","B"]]
        System.out.println(s.updateBoard(
            new char[][] {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
            }, new int[]{3, 0}));
    }
}