/**
 * 3341-find-minimum-time-to-reach-last-room-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/05/10
 */
public class Solution {

    private void dfs(int[][] moveTime, int[][] curTime, int i, int j, int time) {
        if (i < 0 || j < 0 || i >= moveTime.length || j >= moveTime[0].length) {
            return;
        }
        if (curTime[i][j] == -1 || time < curTime[i][j]) {
            curTime[i][j] = Math.max(moveTime[i][j] + 1, time);
            dfs(moveTime, curTime, i - 1, j, curTime[i][j] + 1);
            dfs(moveTime, curTime, i + 1, j, curTime[i][j] + 1);
            dfs(moveTime, curTime, i, j - 1, curTime[i][j] + 1);
            dfs(moveTime, curTime, i, j + 1, curTime[i][j] + 1);
        }
    }

    public int minTimeToReach(int[][] moveTime) {
        int[][] curTime = new int[moveTime.length][moveTime[0].length];
        for (int i = 0; i < moveTime.length; i++) {
            for (int j = 0; j < moveTime[0].length; j++) {
                curTime[i][j] = -1;
            }
        }
        moveTime[0][0] = -1;  // (0,0) is always at 0 second
        dfs(moveTime, curTime, 0, 0, 0);
        return curTime[moveTime.length - 1][moveTime[0].length - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.minTimeToReach(new int[][]{
            {0,4}, {4,4}
        }));
        // 3
        System.out.println(s.minTimeToReach(new int[][]{
            {0,0,0}, {0,0,0}
        }));
        // 3
        System.out.println(s.minTimeToReach(new int[][]{
            {0,1}, {1,2}
        }));
    }
}
