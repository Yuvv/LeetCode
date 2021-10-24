import java.util.*;

/*
 * 0587-erect-the-fence.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/03
 */
public class Solution {
    public int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
    }

    public int distance(int[] p, int[] q) {
        return (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
    }

    private int[] bottomLeft(int[][] points) {
        int[] bottomLeft = points[0];
        for (int[] p : points) {
            if (p[1] < bottomLeft[1]) {
                bottomLeft = p;
            }
        }
        return bottomLeft;
    }

    /**
     * Algotithm: Graham Scan
     *
     * ref: https://leetcode.com/problems/erect-the-fence/solution/
     */
    public int[][] outerTrees(int[][] points) {
        if (points.length <= 1) {
            return points;
        }
        int[] bm = bottomLeft(points);
        Arrays.sort(points, new Comparator<int[]> () {
            public int compare(int[] p, int[] q) {
                double diff = orientation(bm, p, q) - orientation(bm, q, p);
                if (diff == 0) {
                    return distance(bm, p) - distance(bm, q);
                } else {
                    return diff > 0 ? 1 : -1;
                }
            }
        });
        int i = points.length - 1;
        while (i >= 0 && orientation(bm, points[points.length - 1], points[i]) == 0) {
            i--;
        }
        for (int l = i + 1, h = points.length - 1; l < h; l++, h--) {
            int[] temp = points[l];
            points[l] = points[h];
            points[h] = temp;
        }
        LinkedList<int[]> stack = new LinkedList<>();
        stack.push(points[0]);
        stack.push(points[1]);
        for (int j = 2; j < points.length; j++) {
            int[] top = stack.pop();
            while (orientation(stack.peek(), top, points[j]) > 0) {
                top = stack.pop();
            }
            stack.push(top);
            stack.push(points[j]);
        }
        return stack.toArray(new int[stack.size()][]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[1,1],[2,0],[3,3],[2,4],[4,2]]
        System.out.println(Arrays.toString(s.outerTrees(new int[][]{
            {1,1},{2,2},{2,0},{2,4},{3,3},{4,2}
            })));
        // [[4,2],[2,2],[1,2]]
        System.out.println(Arrays.toString(s.outerTrees(new int[][]{
            {1,2},{2,2},{4,2}
            })));
    }
}