import java.util.*;

/*
 * 0973-k-closest-points-to-origin.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/26
 */
public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> -(a[0] * a[0] + a[1] * a[1])));
        for (int[] pt : points) {
            queue.add(pt);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[][] res = new int[k][];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[-2,2]]
        System.out.println(s.kClosest(new int[][] {{1,3},{-2,2}}, 1));
        // [[3,3],[-2,4]]
        System.out.println(s.kClosest(new int[][] {{3,3},{5,-1},{-2,4}}, 2));
    }
}