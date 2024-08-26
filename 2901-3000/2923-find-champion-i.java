/**
 * 2923-find-champion-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/26
 */
public class Solution {
    public int findChampion(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            boolean ok = true;
            for (int j = 0; j < grid[i].length; j++) {
                if (i != j && grid[i][j] != 1) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0
        System.out.println(s.findChampion(new int[][] {{0,1}, {0,0}}));
        // 1
        System.out.println(s.findChampion(new int[][] {{0,0,1}, {1,0,1}, {0,0,0}}));
    }
}
