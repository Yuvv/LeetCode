/*
 * 1275-find-winner-on-a-tic-tac-toe-game.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/20
 */
public class Solution {
    public String tictactoe(int[][] moves) {
        char[] board = new char[9];
        char val = 'A';
        for (int[] mv : moves) {
            board[mv[0] * 3 + mv[1]] = val;
            if (val == 'A') {
                val = 'B';
            } else {
                val = 'A';
            }
        }
        if (board[0] == board[1] && board[1] == board[2] && board[0] != '\0') {
            return "" + board[0];
        }
        if (board[3] == board[4] && board[4] == board[5] && board[3] != '\0') {
            return "" + board[3];
        }
        if (board[6] == board[7] && board[7] == board[8] && board[6] != '\0') {
            return "" + board[4];
        }
        if (board[0] == board[3] && board[0] == board[6] && board[0] != '\0') {
            return "" + board[0];
        }
        if (board[1] == board[4] && board[4] == board[7] && board[1] != '\0') {
            return "" + board[1];
        }
        if (board[2] == board[5] && board[5] == board[8] && board[2] != '\0') {
            return "" + board[2];
        }
        if (board[0] == board[4] && board[4] == board[8] && board[0] != '\0') {
            return "" + board[0];
        }
        if (board[2] == board[4] && board[4] == board[6] && board[2] != '\0') {
            return "" + board[2];
        }
        for (char c : board) {
            if (c != 'A' && c != 'B') {
                return "Pending";
            }
        }
        return "Draw";
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // A
        System.out.println(s.tictactoe(new int[][]{{0,0},{2,0},{1,1},{2,1},{2,2}}));
        // B
        System.out.println(s.tictactoe(new int[][]{{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}}));
        // Draw
        System.out.println(s.tictactoe(new int[][]{{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}}));
        // Pending
        System.out.println(s.tictactoe(new int[][]{{0,0},{1,1}}));
    }
}