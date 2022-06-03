/*
 * 2018-check-if-word-can-be-placed-in-crossword.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/06/03
 */
public class Solution {
    private boolean checkRow(char[] row, String word) {
        for (int k = 0; k <= row.length - word.length(); k++) {
            if (k != 0 && row[k - 1] != '#') {
                // directly left must be '#' or none
                continue;
            }
            int i = k, j = 0;
            while (i < row.length && j < word.length()) {
                if (row[i] == ' ' || row[i] == word.charAt(j)) {
                    i++;
                    j++;
                } else {
                    break;
                }
            }
            if (j >= word.length() && (i >= row.length || row[i] == '#')) {
                // directly right must be '#' or none
                return true;
            }
        }
        return false;
    }

    private boolean checkCol(char[][] board, int k, String word) {
        for (int m = 0; m <= board.length - word.length(); m++) {
            if (m != 0 && board[m - 1][k] != '#') {
                // directly above must be '#' or none
                continue;
            }
            int i = m, j = 0;
            while (i < board.length && j < word.length()) {
                if (board[i][k] == ' ' || board[i][k] == word.charAt(j)) {
                    i++;
                    j++;
                } else {
                    break;
                }
            }
            if (j >= word.length() && (i >= board.length || board[i][k] == '#')) {
                // directly below must be '#' or none
                return true;
            }
        }
        return false;
    }

    public boolean placeWordInCrossword(char[][] board, String word) {
        String reversedWord = new StringBuilder(word).reverse().toString();
        // try row
        if (word.length() <= board[0].length) {
            for (char[] row : board) {
                if (checkRow(row, word)) {
                    return true;
                }
                if (checkRow(row, reversedWord)) {
                    return true;
                }
            }
        }
        // try col
        if (word.length() <= board.length) {
            for (int k = 0; k < board[0].length; k++) {
                if (checkCol(board, k, word)) {
                    return true;
                }
                if (checkCol(board, k, reversedWord)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.placeWordInCrossword(
            new char[][] {
                {'#', ' ', '#'},
                {' ', ' ', '#'},
                {'#', 'c', ' '}
            }, "abc"
        ));
        // false
        System.out.println(s.placeWordInCrossword(
            new char[][] {
                {' ', '#', 'a'},
                {' ', '#', 'c'},
                {' ', '#', 'a'}
            }, "ac"
        ));
        // true
        System.out.println(s.placeWordInCrossword(
            new char[][] {
                {' ', '#', 'o', ' ', 't', 'm', 'o', ' ', '#', ' '}
            }, "octmor"
        ));
        // true
        System.out.println(s.placeWordInCrossword(
            new char[][] {
                {' '}, {'#'}, {'o'}, {' '}, {'t'}, {'m'}, {'o'}, {' '}, {'#'}, {' '}
            }, "octmor"
        ));
    }
}