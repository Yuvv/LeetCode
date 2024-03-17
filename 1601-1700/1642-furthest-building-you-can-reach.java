import java.util.*;


/**
 * 1642-furthest-building-you-can-reach.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/03/17
 */
public class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int i = 1;
        while (i < heights.length) {
            int v = heights[i] - heights[i-1];
            if (v <= 0) {
                i++;
            } else {
                bricks -= v;
                pq.add(v);
                while (ladders > 0 && bricks < 0 && !pq.isEmpty()) {
                    bricks += pq.poll();
                    ladders--;
                }
                if (bricks >= 0) {
                    i++;
                } else {
                    return i - 1;
                }
            }
        }
        return heights.length - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.furthestBuilding(new int[]{4,2,7,6,9,14,12}, 5, 1));
        // 7
        System.out.println(s.furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19}, 10, 2));
        // 3
        System.out.println(s.furthestBuilding(new int[]{14,3,19,3}, 17, 0));
    }
}
