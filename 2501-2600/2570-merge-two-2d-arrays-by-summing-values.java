import java.util.*;
/**
 * 2570-merge-two-2d-arrays-by-summing-values.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/03/03
 */
public class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] num: nums1) {
            map.put(num[0], map.getOrDefault(num[0], 0) + num[1]);
        }
        for (int[] num: nums2) {
            map.put(num[0], map.getOrDefault(num[0], 0) + num[1]);
        }
        int[][] res = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            res[i][0] = entry.getKey();
            res[i][1] = entry.getValue();
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[1,6],[2,3],[3,2],[4,6]]
        System.out.println(s.mergeArrays(
            new int[][]{{1,2}, {2,3}, {4, 5}},
            new int[][]{{1,4}, {3,2}, {4, 1}}
        ));
    }
}
