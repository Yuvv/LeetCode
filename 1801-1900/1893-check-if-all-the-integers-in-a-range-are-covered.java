import java.util.*;

/*
 * 1893-check-if-all-the-integers-in-a-range-are-covered.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/24
 */
public class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        List<int[]> toCover = new LinkedList<>();
        toCover.add(new int[] {left, right});
        for (int[] each : ranges) {
            ListIterator<int[]> it = toCover.listIterator();
            while (it.hasNext()) {
                int[] rr = it.next();
                if (each[0] <= rr[0] && each[1] >= rr[1]) {
                    it.remove();
                } else if (each[0] <= rr[0] && each[1] >= rr[0]) {
                    rr[0] = each[1] + 1;
                } else if (each[0] > rr[0] && each[0] <= rr[1] && each[1] >= rr[1]) {
                    rr[1] = each[0] - 1;
                } else if (each[0] > rr[0] && each[1] < rr[1]) {
                    int[] rrSplit = new int[] {rr[0], each[0] - 1};
                    rr[0] = each[1] + 1;
                    it.add(rrSplit);
                }
            }
            if (toCover.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isCovered(
            new int[][] {{1,2}, {3,4}, {5,6}},
            2, 5
        ));
        // true
        System.out.println(s.isCovered(
            new int[][] {{2,2}, {3,3}, {1,1}},
            1, 3
        ));
    }
}