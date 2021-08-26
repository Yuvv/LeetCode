import java.util.*;

/*
 * 0850-rectangle-area-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/22
 */
public class Solution {

    public int rectangleArea(int[][] rectangles) {
        long res = 0;
        long mod = 1000000007L;

        int OPEN = 0, CLOSE = 1;
        int[][] events = new int[rectangles.length * 2][];
        int t = 0;
        for (int[] rec: rectangles) {
            events[t++] = new int[]{rec[1], OPEN, rec[0], rec[2]};
            events[t++] = new int[]{rec[3], CLOSE, rec[0], rec[2]};
        }

        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        List<int[]> active = new ArrayList<>();
        int cur_y = events[0][0];
        for (int[] event: events) {
            int y = event[0], type = event[1], x1 = event[2], x2 = event[3];

            // Calculate query
            long query = 0;
            int cur = -1;
            for (int[] xs: active) {
                cur = Math.max(cur, xs[0]);
                query += Math.max(xs[1] - cur, 0);
                cur = Math.max(cur, xs[1]);
            }

            res += query * (y - cur_y);

            if (type == OPEN) {
                active.add(new int[]{x1, x2});
                active.sort(Comparator.comparingInt(a -> a[0]));
            } else {
                for (int i = 0; i < active.size(); ++i)
                    // remove duplicated
                    if (active.get(i)[0] == x1 && active.get(i)[1] == x2) {
                        active.remove(i);
                        break;
                    }
            }

            cur_y = y;
        }

        return (int) (res % mod);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 18
        System.out.println(s.rectangleArea(new int[][]{
                new int[]{0, 0, 3, 3},
                new int[]{2, 0, 5, 3},
                new int[]{1, 1, 4, 4}
        }));
        // 6
        System.out.println(s.rectangleArea(new int[][]{
                new int[]{0, 0, 2, 2},
                new int[]{1, 0, 2, 3},
                new int[]{1, 0, 3, 1}
        }));
        // 49
        System.out.println(s.rectangleArea(new int[][]{
                new int[]{0, 0, 1000000000, 1000000000}
        }));
        // 10
        System.out.println(s.rectangleArea(new int[][]{
                new int[]{0, 0, 2, 2},
                new int[]{0, 1, 2, 2},
                new int[]{0, 3, 2, 5},
                new int[]{1, 0, 2, 3},
                new int[]{1, 0, 3, 1}
        }));
    }
}