import java.util.*;

/*
 * 407-trapping-rain-water-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/03
 */
public class Solution {
    public int trapRainWater(int[][] heightMap) {
        int row = heightMap.length;
        int col = heightMap[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        Set<String> checked = new HashSet<>(row * col);
        for (int i = 0; i < row; i++) {
            pq.add(new int[] {i, 0, heightMap[i][0]});
            pq.add(new int[] {i, col - 1, heightMap[i][col - 1]});
            checked.add(i + ",0");
            checked.add(i + "," + (col - 1));
        }
        for (int j = 0; j < col; j++) {
            pq.add(new int[] {0, j, heightMap[0][j]});
            pq.add(new int[] {row - 1, j, heightMap[row - 1][j]});
            checked.add("0," + j);
            checked.add((row - 1) + "," + j);
        }

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] pt = pq.poll();
            for (int[] dir : directions) {
                int i = pt[0] + dir[0];
                int j = pt[1] + dir[1];
                String key = i + "," + j;
                if (i >= 0 && j >= 0 && i < row && j < col && !checked.contains(key)) {
                    checked.add(key);
                    sum += Math.max(0, pt[2] - heightMap[i][j]);
                    pq.add(new int[] {i, j, Math.max(heightMap[i][j], pt[2])});
                }
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.trapRainWater(
            new int[][] {
                {1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}
            }
        ));
        // 10
        System.out.println(s.trapRainWater(
            new int[][] {
                {3,3,3,3,3},
                {3,2,2,2,3},
                {3,2,1,2,3},
                {3,2,2,2,3},
                {3,3,3,3,3}
            }
        ));
        // 0
        System.out.println(s.trapRainWater(
            new int[][] {
                {2,3,4},
                {5,6,7},
                {8,9,10},
                {11,12,13},
                {14,15,16}
            }
        ));
    }
}

/*

[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
[[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
[[3,3,3,3,3],[3,2,2,2,3],[3,2,3,2,3],[3,2,2,2,3],[3,3,3,3,3]]
[[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,2,3]]
[[2,3,4],[5,6,7],[8,9,10],[11,12,13],[14,15,16]]
[[5,8,7,7],[5,2,1,5],[7,1,7,1],[8,9,6,9],[9,8,9,9]]


*/