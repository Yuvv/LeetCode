import java.util.LinkedList;

/**
 * 1765-map-of-highest-peak.java
 *
 * @date 2024/1/31
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int nRow = isWater.length;
        int nCol = isWater[0].length;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(i * nCol + j);
                    isWater[i][j] = 0;
                } else {
                    isWater[i][j] = -1;
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Integer val = queue.poll();
                int i = val / nCol;
                int j = val % nCol;
                int v = isWater[i][j];
                if (i > 0 && isWater[i-1][j] < 0) {
                    isWater[i-1][j] = v+1;
                    queue.addLast((i-1)*nCol+j);
                }
                if (j > 0 && isWater[i][j-1] < 0) {
                    isWater[i][j-1] = v+1;
                    queue.addLast(i*nCol+j-1);
                }
                if (i < nRow-1 && isWater[i+1][j] < 0) {
                    isWater[i+1][j] = v+1;
                    queue.addLast((i+1)*nCol+j);
                }
                if (j < nCol-1 && isWater[i][j+1] < 0) {
                    isWater[i][j+1] = v+1;
                    queue.addLast(i*nCol+j+1);
                }
                size--;
            }
        }
        return isWater;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // [[1,0],[2,1]]
        System.out.println(s.highestPeak(
                    new int[][]{{0,1},{0,0}}
                    ));
        // [[1,1,0],[0,1,1],[1,2,2]]
        System.out.println(s.highestPeak(
                    new int[][]{{0,0,1},{1,0,0},{0,0,0}}
                    ));
    }
}
