import java.util.*;

/*
 * 1981-minimize-the-difference-between-target-and-chosen-elements.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/22
 */
public class Solution {
    private Map<Integer, Map<Integer, Integer>> cacheMap;

    public int minimizeTheDifference(int[][] mat, int target) {
        cacheMap = new HashMap<>();
        List<List<Integer>> matList = new ArrayList<>(mat.length);
        int minSum = 0, maxSum = 0;
        for (int [] row : mat) {
            Set<Integer> set = new TreeSet<>();
            for (int cell : row) {
                set.add(cell);
            }
            List<Integer> rowList = new ArrayList<>(set);
            minSum += rowList.get(0);
            maxSum += rowList.get(rowList.size() - 1);
            matList.add(rowList);

        }
        return getMinDiff(matList, 0, target, minSum, maxSum);
    }

    public int getMinDiff(List<List<Integer>> matList, int row, int target, int minSum, int maxSum) {
        if (row >= matList.size()) {
            return Math.abs(target);
        }
        if (minSum >= target) {
            return minSum - target;
        }
        if (maxSum <= target) {
            return target - maxSum;
        }
        if (cacheMap.containsKey(row) && cacheMap.get(row).containsKey(target)) {
            return cacheMap.get(row).get(target);
        }
        int minDiff = Integer.MAX_VALUE;
        for (Integer each : matList.get(row)) {
            minDiff = Math.min(minDiff, getMinDiff(matList, row + 1, target - each, minSum - each, maxSum - each));
            if (minDiff == 0) {
                // fast return
                return 0;
            }
        }
        cacheMap.computeIfAbsent(row, k -> new HashMap<>()).put(target, minDiff);
        return minDiff;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0
        System.out.println(s.minimizeTheDifference(
            new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 13));
        // 94
        System.out.println(s.minimizeTheDifference(
            new int[][]{{1},{2},{3}}, 100));
        // 1
        System.out.println(s.minimizeTheDifference(
            new int[][]{{1, 2, 9, 8, 7}}, 6));
        // 3
        System.out.println(s.minimizeTheDifference(
            new int[][]{
                {10,3,7,7,9,6,9,8,9,5},
                {1,1,6,8,6,7,7,9,3,9},
                {3,4,4,1,3,6,3,3,9,9},
                {6,9,9,3,8,7,9,6,10,6}}, 5));
    }
}