import java.util.*;
/**
 * 3342-find-minimum-time-to-reach-last-room-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/05/10
 */
public class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int N = moveTime.length;
        int M = moveTime[0].length;
        int[][] mincost = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                mincost[i][j] = -1;
            }
        }
        // (i, j, time, cost)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{0, 0, 0, 1});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] == N - 1 && cur[1] == M - 1) {
                return cur[2];
            }
            if (cur[0] < N-1) { // down
                int c = Math.max(cur[2], moveTime[cur[0]+1][cur[1]]) + cur[3];
                if (mincost[cur[0]+1][cur[1]] <= 0 || c < mincost[cur[0]+1][cur[1]]) {
                    mincost[cur[0]+1][cur[1]] = c;
                    pq.add(new int[]{cur[0] + 1, cur[1], c, cur[3] == 1 ? 2:1});
                }
            }
            if (cur[0] > 0) { // up
                int c = Math.max(cur[2], moveTime[cur[0]-1][cur[1]]) + cur[3];
                if (mincost[cur[0]-1][cur[1]] <= 0 || c < mincost[cur[0]-1][cur[1]]) {
                    mincost[cur[0]-1][cur[1]] = c;
                    pq.add(new int[]{cur[0]-1, cur[1], c, cur[3] == 1 ? 2:1});
                }
            }
            if (cur[1] < M-1) { // right
                int c = Math.max(cur[2], moveTime[cur[0]][cur[1]+1]) + cur[3];
                if (mincost[cur[0]][cur[1]+1] <= 0 || c < mincost[cur[0]][cur[1]+1]) {
                    mincost[cur[0]][cur[1]+1] = c;
                    pq.add(new int[]{cur[0], cur[1] + 1, c, cur[3] == 1 ? 2:1});
                }
            }
            if (cur[1] > 0) { // left
                int c = Math.max(cur[2], moveTime[cur[0]][cur[1]-1]) + cur[3];
                if (mincost[cur[0]][cur[1]-1] <= 0 || c < mincost[cur[0]][cur[1]-1]) {
                    mincost[cur[0]][cur[1]-1] = c;
                    pq.add(new int[]{cur[0], cur[1] - 1, c, cur[3] == 1 ? 2:1});
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 7
        System.out.println(s.minTimeToReach(new int[][]{
            {0,4}, {4,4}
        }));
        // 6
        System.out.println(s.minTimeToReach(new int[][]{
            {0,0,0,0}, {0,0,0,0}
        }));
        // 4
        System.out.println(s.minTimeToReach(new int[][]{
            {0,1}, {1,2}
        }));
        // 76
        System.out.println(s.minTimeToReach(new int[][]{
            {38,87,68,34,32,8}, {3,29,39,73,86,10}
        }));
    }
}