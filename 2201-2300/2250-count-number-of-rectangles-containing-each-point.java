import java.util.*;

/*
 * 2250-count-number-of-rectangles-containing-each-point.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/01
 */
public class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        // All the rectangles are unique.
        TreeMap<Integer, TreeSet<int[]>> treeMap = new TreeMap<>();
        for (int[] rec : rectangles) {
            treeMap.computeIfAbsent(rec[1], k -> new TreeSet<>(Comparator.comparingInt(x -> x[0]))).add(new int[] {rec[0], 0});
        }
        for (TreeSet<int[]> value : treeMap.values()) {
            int i = 0;
            for (int[] pair : value) {
                pair[1] = i++;
            }
        }
        int[] res = new int[points.length];
        int i = 0;
        for (int[] pt : points) {
            int sum = 0;
            for (TreeSet<int[]> xSet : treeMap.tailMap(pt[1], true).values()) {
                int[] ceiling = xSet.ceiling(new int[] {pt[0], 0});
                if (ceiling != null) {
                    sum += xSet.size() - ceiling[1];
                }
            }
            res[i++] = sum;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [2,1]
        System.out.println(Arrays.toString(s.countRectangles(
            new int[][] {{1,2}, {2, 3}, {2,5}},
            new int[][] {{2,1}, {1,4}}
        )));
        // [1,3]
        System.out.println(Arrays.toString(s.countRectangles(
            new int[][] {{1,1}, {2, 2}, {3,3}},
            new int[][] {{1,3}, {1,1}}
        )));
    }
}