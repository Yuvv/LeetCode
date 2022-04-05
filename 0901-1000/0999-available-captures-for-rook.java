/*
 * 0999-available-captures-for-rook.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/05
 */
public class Solution {
    public int numRookCaptures(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            char[] row = board[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 'R') {
                    // find rook, then extend
                    int k = j - 1;
                    while (k >= 0 && row[k] == '.') {
                        k--;
                    }
                    if (k >= 0 && row[k] == 'p') {
                        count++;
                    }
                    k = j + 1;
                    while (k < row.length && row[k] == '.') {
                        k++;
                    }
                    if (k < row.length && row[k] == 'p') {
                        count++;
                    }
                    k = i - 1;
                    while (k >= 0 && board[k][j] == '.') {
                        k--;
                    }
                    if (k >= 0 && board[k][j] == 'p') {
                        count++;
                    }
                    k = i + 1;
                    while (k < board.length && board[k][j] == '.') {
                        k++;
                    }
                    if (k < board.length && board[k][j] == 'p') {
                        count++;
                    }
                    return count;
                }
            }
        }
        return count;
    }
}