import java.util.*;
import java.util.stream.*;

/**
 * 2192-all-ancestors-of-a-node-in-a-directed-acyclic-graph.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/29
 */
public class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            map.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        Map<Integer, Set<Integer>> resMap = new HashMap<>();
        for (int i = 0 ; i < n; i++) {
            dfs(resMap, map, i);
        }
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            resList.add(resMap.get(i).stream().sorted().collect(Collectors.toList()));
        }
        return resList;
    }

    private void dfs(Map<Integer, Set<Integer>> resMap, Map<Integer, List<Integer>> l1map, int i) {
        if (resMap.containsKey(i)) {
            return;
        }
        if (!l1map.containsKey(i)) {
            resMap.put(i, new HashSet<>(0));
            return;
        }
        Set<Integer> p1 = new HashSet<>(l1map.get(i));
        for (Integer p : l1map.get(i)) {
            dfs(resMap, l1map, p);
            p1.addAll(resMap.get(p));
        }
        resMap.put(i, p1);
        return;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[],[],[],[0,1],[0,2],[0,1,3],[0,1,2,3,4],[0,1,2,3]]
        System.out.println(s.getAncestors(8, new int[][]{{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}}));
    }
}