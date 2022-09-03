/*
 * 0498-diagonal-traverse.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/09/03
 */
public class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int[][] direction = new int[][] {{-1, 1}, {1, -1}};
        int di = 0;
        int i = 0, j = 0;
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        for (int k = 0; k < res.length; k++) {
            res[k] = mat[i][j];
            if (k == res.length - 1) {
                continue;
            }

            int nexti = i + direction[di][0];
            int nextj = j + direction[di][1];
            if (!isOk(nexti, nextj , m, n)) {
                if (di == 0) {
                    // up-right
                    if (isOk(i, j + 1, m, n)) {  // 1. try right
                        nexti = i;
                        nextj = j + 1;
                    } else if (isOk(i + 1, j, m, n)) {  // 2. try down
                        nexti = i + 1;
                        nextj = j;
                    } else {
                        System.out.println("0. what?");
                        return null;
                    }
                } else {
                    // down-left
                    if (isOk(i + 1, j, m, n)) { // 1. trydown
                        nexti = i + 1;
                        nextj = j;
                    } else if (isOk(i, j + 1, m, n)) {  // 2. try right
                        nexti = i;
                        nextj = j + 1;
                    } else {
                        System.out.println("1. what?");
                        return null;
                    }
                }
                di = 1 - di;
            }
            i = nexti;
            j = nextj;
        }
        return res;
    }

    private boolean isOk(int i, int j, int m, int n) {
        if (i < 0) {
            return false;
        }
        if (j < 0) {
            return false;
        }
        if (i >= m) {
            return false;
        }
        if (j >= n) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,2,4,7,5,3,6,8,9]
        System.out.println(java.util.Arrays.toString(
            s.findDiagonalOrder(new int[][] {
                {1,2,3}, {4,5,6}, {7,8,9}
            })
        ));
    }
}