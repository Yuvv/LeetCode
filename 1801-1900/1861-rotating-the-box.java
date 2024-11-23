/**
 * 1861-rotating-the-box.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/11/23
 */
public class Solution {
    public char[][] rotateTheBox(char[][] box) {
        for (char[] row : box) {
            int j = row.length-1;
            int i = j-1;
            while (j >= 0 && i >= 0) {
                while (j >= 0 && row[j] != '.') {
                    j--;
                }
                i = j-1;
                while (i >= 0 && row[i] == '.') {
                    i--;
                }
                if (i >= 0 && row[i] == '#' && i < j && row[j] == '.') {
                    row[j] = '#';
                    row[i] = '.';
                    j--;
                } else {
                    j = i;
                }
            }
        }
        char[][] res = new char[box[0].length][box.length];
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[i].length; j++) {
                res[j][box.length - 1 - i] = box[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [["."], ["#"], ["#"]]
        System.out.println(s.rotateTheBox(new char[][]{{'#', '.', '#'}}));
        // [["#", "."], ["#","#"], ["*", "*"], [".", "."]]
        System.out.println(s.rotateTheBox(new char[][]{
            {'#', '.', '*', '.'},
            {'#', '#', '*', '.'}
        }));
    }
}
