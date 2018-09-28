class Solution {
    /**
     * N 字形字符串
     * https://leetcode.com/problems/zigzag-conversion/description/
     */
    public String convert(String s, int numRows) {
        if (s.length() == 0 || numRows == 1) {
            return s;
        }
        int base = 2 * numRows - 2;
        int numCols = s.length() / base * (numRows - 1);
        int remainder = s.length() % base;
        if (remainder > 0) {
            if (remainder <= numRows) {
                numCols += 1;
            } else {
                numCols += remainder - numRows + 1;
            }
        }

        char[][] matrix = new char[numRows][numCols];

        int i = 1, j = -1;
        for (int k = 0; k < s.length(); k++) {
            remainder = k % base;
            if (remainder == 0 || remainder >= numRows) {
                i--;
                j++;
            } else {
                i++;
            }
            matrix[i][j] = s.charAt(k);
        }

        StringBuilder sb = new StringBuilder(s.length());
        for (i = 0; i < numRows; i++) {
            for (j = 0; j < numCols; j++) {
                if (matrix[i][j] != 0) {
                    sb.append(matrix[i][j]);
                }
            }
        }
        return sb.toString();
    }
}