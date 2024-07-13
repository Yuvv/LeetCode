import java.util.*;
import java.util.stream.*;

/**
 * 2715-robot-collisions.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/13
 */
public class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < positions.length; i++) {
            pq.add(new int[]{positions[i], healths[i], directions.charAt(i), i});
        }
        PriorityQueue<int[]> resPQ = new PriorityQueue<>(Comparator.comparingInt(a -> a[3]));
        LinkedList<int[]> rStack = new LinkedList<>();  // stores R
        while (!pq.isEmpty()) {
            int[] ele = pq.poll();
            if (ele[2] == 'R') {
                rStack.push(ele);
            } else { // 'L' - may collide with robots in R-stack
                while (!rStack.isEmpty() && ele[1] > 0 && rStack.peek()[1] < ele[1]) {
                    rStack.pop();
                    ele[1]--;
                }
                if (!rStack.isEmpty()) {
                    if (rStack.peek()[1] == ele[1]) {
                        rStack.pop();
                    } else { // >
                        rStack.peek()[1]--;
                    }
                    ele[1] = 0;
                }
                if (ele[1] > 0) {
                    resPQ.add(ele);
                }
            }
        }
        // add all
        resPQ.addAll(rStack);
        List<Integer> resList = new ArrayList<>();
        while (!resPQ.isEmpty()) {
            resList.add(resPQ.poll()[1]);
        }
        return resList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [2,17,9,15,10]
        System.out.println(s.survivedRobotsHealths(
                new int[]{5, 4, 3, 2, 1},
                new int[]{2, 17, 9, 15, 10},
                "RRRRR"
        ));
        // [14]
        System.out.println(s.survivedRobotsHealths(
                new int[]{3, 5, 2, 6},
                new int[]{10, 10, 15, 12},
                "RLRL"
        ));
        // []
        System.out.println(s.survivedRobotsHealths(
                new int[]{1, 2, 5, 6},
                new int[]{10, 10, 11, 11},
                "RLRL"
        ));
    }
}
