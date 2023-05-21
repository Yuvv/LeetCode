import java.util.*;

/*
 * 2679-sum-in-a-matrix.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/05/21
 */
public class Solution {
    public int matrixSum(int[][] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return b[0] - a[0];
        });
        for (int[] row : nums) {
            Arrays.sort(row);
            for (int i = 0; i < row.length; i++) {
                pq.add(new int[]{i, row[i]});
            }
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll()[1];
            int n = nums.length - 1;
            while (n > 0) {
                pq.poll();
                n--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 15
        System.out.println(s.matrixSum(
            new int[][] {
                {7,2,1},
                {6,4,2},
                {6,5,3},
                {3,2,1}
            }
        ));
    }
}