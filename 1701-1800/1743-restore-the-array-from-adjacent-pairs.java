import java.util.*;

/**
 * 1743-restore-the-array-from-adjacent-pairs
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/11/19
 */
public class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        if (adjacentPairs.length == 1) {
            return adjacentPairs[0];
        }
        Map<Integer, List<Integer>> map = new HashMap<>(adjacentPairs.length);
        for (int[] pair : adjacentPairs) {
            map.computeIfAbsent(pair[0], k -> new ArrayList<>(2)).add(pair[1]);
            map.computeIfAbsent(pair[1], k -> new ArrayList<>(2)).add(pair[0]);
        }
        int start = Integer.MIN_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                start = entry.getKey();
                break;
            }
        }
        int[] res = new int[adjacentPairs.length + 1];
        if (start == Integer.MIN_VALUE) {
            System.err.println("find start failed");
            return res;
        }

        res[0] = start;
        Set<Integer> seenSet = new HashSet<>(res.length);
        seenSet.add(start);
        if (!dfs(map, seenSet, 1, res)) {
            System.err.println("dfs failed");
        }
        return res;
    }

    private boolean dfs(Map<Integer, List<Integer>> map, Set<Integer> seenSet, int i, int[] res) {
        if (i >= res.length) {
            return true;
        }
        int prev = res[i - 1];
        for (Integer next : map.get(prev)) {
            if (seenSet.contains(next)) {
                continue;
            }
            res[i] = next;
            seenSet.add(next);
            if (dfs(map, seenSet, i + 1, res)) {
                return true;
            }
            seenSet.remove(next);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,2,3,4] or reversed
        System.out.println(Arrays.toString(s.restoreArray(new int[][] {
                { 2, 1 }, { 3, 4 }, { 3, 2 }
        })));
        // [-2,4,1,-3] or reversed
        System.out.println(Arrays.toString(s.restoreArray(new int[][] {
                { 4, -2 }, { 1, 4 }, { -3, 1 }
        })));
        // [1,-1] or reversed
        System.out.println(Arrays.toString(s.restoreArray(new int[][] {
                { 1, -1 }
        })));
    }
}
