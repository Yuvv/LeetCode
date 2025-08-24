import java.util.PriorityQueue;

/**
 * 3567-minimum-absolute-difference-in-sliding-submatrix.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/08/24
 */
public class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int[][] res = new int[grid.length-k+1][grid[0].length-k+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <= grid.length-k; i++) {
            for (int j = 0; j <= grid[i].length-k; j++) {
                for (int ii = i; ii < i+k; ii++) {
                    for (int jj = j; jj < j+k; jj++) {
                        pq.add(grid[ii][jj]);
                    }
                }
                Integer f = pq.poll();
                int min = Integer.MAX_VALUE;
                while (!pq.isEmpty()) {
                    int n = pq.poll();
                    if (n == f) {
                        continue;
                    }
                    min = Math.min(min, n - f);
                    f = n;
                }
                if (min == Integer.MAX_VALUE) {
                    res[i][j] = 0;
                } else {
                    res[i][j] = min;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[2]]
        System.out.println(s.minAbsDiff(
            new int[][]{{1,8}, {3,-2}}, 2
        ));
        // [[0,0]]
        System.out.println(s.minAbsDiff(
            new int[][]{{3,-1}}, 1
        ));
    }
}