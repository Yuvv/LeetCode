/**
 * 1582-special-positions-in-a-binary-matrix
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/12/18
 */
public class Solution {
    public int numSpecial(int[][] mat) {
        int[] rowOnes = new int[mat.length];
        int[] colOnes = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    rowOnes[i] += 1;
                    colOnes[j] += 1;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < mat.length; i++) {
            if (rowOnes[i] != 1) {
                continue;
            }
            for (int j = 0; j < mat[i].length; j++) {
                if (colOnes[j] != 1) {
                    continue;
                }
                if (mat[i][j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.numSpecial(
                    new int[][]{{1,0,0},{0,0,1},{1,0,0}}
                    ));
        // 3
        System.out.println(s.numSpecial(
                    new int[][]{{1,0,0},{0,1,0},{0,0,1}}
                    ));
    }
}
