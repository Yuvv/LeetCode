/*
 * 0130-surrounded-regions.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/06/08
 */
public class Solution {

    private byte[][] checkedBoard;

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        // init checkedBoard
        checkedBoard = new byte[board.length][];
        for (int i = 0; i < board.length; i++) {
            checkedBoard[i] = new byte[board[i].length];
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (checkedBoard[i][j] == 1) {
                    continue;
                }
                if (board[i][j] == 'O') {
                    boolean isNeedFlip = checkForFlip(board, i, j);
                    flipOrCheck(board, i, j, isNeedFlip);
                }
                checkedBoard[i][j] = 1;
            }
        }
    }

    /**
     * return `true` if position (i, j) is ok, `false` if position (i, j) need to flip
     */
    public boolean checkForFlip(char[][] board, int i, int j) {
        // check only right, left, bottom
        if (board[i][j] == 'O') {
            if (i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) {
                return false;
            }
        } else {
            return true;
        }
        boolean checkResult;
        checkedBoard[i][j] = 2;
        // bottom
        if (i < board.length - 1) {
            checkResult = checkForFlip(board, i + 1, j);
            if (!checkResult) {
                // fast false
                return false;
            }
        }
        // top
        if (i > 0 && checkedBoard[i - 1][j] == 0) {
            checkResult = checkForFlip(board, i - 1, j);
            if (!checkResult) {
                // fast false
                return false;
            }
        }
        // right
        if (j < board[i].length - 1 && checkedBoard[i][j + 1] == 0) {
            checkResult = checkForFlip(board, i, j + 1);
            if (!checkResult) {
                // fast false
                return false;
            }
        }
        // left
        if (j > 0 && checkedBoard[i][j - 1] == 0) {
            checkResult = checkForFlip(board, i, j - 1);
            if (!checkResult) {
                // fast false
                return false;
            }
        }
        return true;
    }

    public void flipOrCheck(char[][] board, int i, int j, boolean flip) {
        if (board[i][j] == 'X') {
            return;
        }
        if (checkedBoard[i][j] == 1) {
            return;
        }
        checkedBoard[i][j] = 1;
        if (flip) {
            board[i][j] = 'X';
        }
        // flip left, right, top, bottom
        if (i > 0) {
            flipOrCheck(board, i - 1, j, flip);
        }
        if (j > 0) {
            flipOrCheck(board, i, j - 1, flip);
        }
        if (i < board.length - 1) {
            flipOrCheck(board, i + 1,  j, flip);
        }
        if (j < board[i].length - 1) {
            flipOrCheck(board, i,  j + 1, flip);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //
        char[][] board = new char[][] {
            new char[]{'X', 'X', 'X', 'X'},
            new char[]{'X', 'O', 'O', 'X'},
            new char[]{'X', 'X', 'O', 'X'},
            new char[]{'X', 'O', 'X', 'X'}
        };
        s.solve(board);
        printBoard(board);

        char[][] board2 = new char[][] {
            new char[] {'O', 'X', 'O', 'O', 'X', 'X'},
            new char[] {'O', 'X', 'X', 'X', 'O', 'X'},
            new char[] {'X', 'O', 'O', 'X', 'O', 'O'},
            new char[] {'X', 'O', 'X', 'X', 'X', 'X'},
            new char[] {'O', 'O', 'X', 'O', 'X', 'X'},
            new char[] {'X', 'X', 'O', 'O', 'O', 'O'},
        };
        s.solve(board2);
        printBoard(board2);
    }

    static void printBoard(char[][] board) {
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar);
                System.out.print(' ');
            }
            System.out.println();
        }
        System.out.println();
    }
}