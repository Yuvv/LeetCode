/**
 * 3537-fill-a-special-grid.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/08/19
 */
public class Solution {
    public int[][] specialGrid(int n) {
        int N = (int)Math.pow(2, n);
        int M = (int)Math.pow(2, 2*n) - 1;
        int[][] res = new int[N][N];
        solve(res, 0,0, N, 0, M);
        return res;
    }

    private void solve(int[][] res, int bi, int bj, int bn, int min, int max) {
        if (bn == 1) {
            res[bi][bj] = min;
            return;
        }
        int q = (max+1-min)/4;
        int nn = bn/2;
        // top-right
        solve(res, bi, bj+nn, nn, min, min+q-1);
        // bottom-right
        solve(res, bi+nn, bj+nn, nn, min+q, min+2*q-1);
        // bottom-left
        solve(res, bi+nn, bj, nn, min+2*q, min+3*q-1);
        // top-left
        solve(res, bi, bj, nn, min+3*q, max);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[0]]
        System.out.println(s.specialGrid(0));
        // [[3,0],[2,1]]
        System.out.println(s.specialGrid(1));
        // [[15,12,3,0],[14,13,2,1],[11,8,7,4],[10,9,6,5]]
        System.out.println(s.specialGrid(2));
    }
}