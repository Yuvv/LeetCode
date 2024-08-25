import java.util.*;

/**
 * 3249-count-the-number-of-good-nodes.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/25
 */
public class Solution {
    public int countGoodNodes(int[][] edges) {
        Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
        for (int[] edge : edges) {
            edgeMap.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            edgeMap.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }
        Map<Integer, Set<Integer>> nodeMap = new HashMap<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Integer v = queue.pollFirst();
                Set<Integer> next = edgeMap.get(v);
                if (next != null) {
                    Set<Integer> nextSet = nodeMap.computeIfAbsent(v, k -> new HashSet<>());
                    for (Integer nv : next) {
                        if (!nodeMap.containsKey(nv)) {
                            nextSet.add(nv);
                            queue.addLast(nv);
                        }
                    }
                }
                size--;
            }
        }
        Map<Integer, Integer> sizeMap = new HashMap<>();
        dfsSize(nodeMap, sizeMap, 0);
        int cnt = 0;
        for (Map.Entry<Integer, Set<Integer>> entry : nodeMap.entrySet()) {
            int size = -1;
            boolean good = true;
            for (Integer v : entry.getValue()) {
                if (size >= 0 && sizeMap.get(v) != size) {
                    good = false;
                    break;
                }
                size = sizeMap.get(v);
            }
            if (good) {
                cnt++;
            }
        }
        return cnt;
    }

    private int dfsSize(Map<Integer, Set<Integer>> nodeMap, Map<Integer, Integer> sizeMap, Integer v) {
        if (sizeMap.containsKey(v)) {
            return sizeMap.get(v);
        }
        if (!nodeMap.containsKey(v)) {
            sizeMap.put(v, 0);
            return 0;
        }
        int cnt = 0;
        for (Integer nv : nodeMap.get(v)) {
            cnt += 1 + dfsSize(nodeMap, sizeMap, nv);
        }
        sizeMap.put(v, cnt);
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 7
        System.out.println(s.countGoodNodes(
            new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}}
        ));
    }
}
