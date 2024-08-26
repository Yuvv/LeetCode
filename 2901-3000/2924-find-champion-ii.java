/**
 * 2924-find-champion-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/26
 */
public class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] ind = new int[n];
        for (int[] e : edges) {
            ind[e[1]]++;
        }
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (ind[i] == 0) {
                if (res >= 0) {
                    return -1;
                }
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0
        System.out.println(s.findChampion(3, new int[][]{{0,1}, {1,2}}));
        // -1
        System.out.println(s.findChampion(4, new int[][]{{0,2}, {1,3}, {1,2}}));
    }
}
