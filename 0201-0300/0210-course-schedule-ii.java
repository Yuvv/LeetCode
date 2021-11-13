import java.util.*;

/*
 * 0210-course-schedule-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/13
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer> visited = new HashSet<>(numCourses);
        LinkedList<Integer> stack = new LinkedList<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>(prerequisites.length);
        for (int[] req : prerequisites) {
            graph.computeIfAbsent(req[1], k -> new HashSet<>()).add(req[0]);
        }
        // toplogical sort
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            if (visited.contains(entry.getKey())) {
                continue;
            }
            // dfs search
            if (!dfs(graph, new HashSet<>(), visited, stack, entry.getKey())) {
                return new int[0];
            }
        }

        int[] res = new int[numCourses];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pop();
        }
        for (int j = 0; j < numCourses; j++) {
            if (!visited.contains(j)) {
                res[i++] = j;
            }
        }
        return res;
    }

    public boolean dfs(Map<Integer, Set<Integer>> graph,
                       Set<Integer> path,
                       Set<Integer> visited,
                       LinkedList<Integer> stack,
                       Integer val) {
        if (path.contains(val)) {
            // cycle exists
            return false;
        }
        if (visited.contains(val)) {
            // already visited
            return true;
        }
        visited.add(val);
        path.add(val);
        for (Integer next : graph.getOrDefault(val, Collections.emptySet())) {
            if (!dfs(graph, path, visited, stack, next)) {
                return false;
            }
        }
        path.remove(val);
        stack.push(val);
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [0,1]
        System.out.println(Arrays.toString(s.findOrder(2, new int[][]{{1, 0}})));
        // [0,2,1,3]
        System.out.println(Arrays.toString(s.findOrder(4, new int[][]{{1,0}, {2,0}, {3,1}, {3,2}})));
        // [0]
        System.out.println(Arrays.toString(s.findOrder(1, new int[][]{})));
        // [] --- has cycle
        System.out.println(Arrays.toString(s.findOrder(9, new int[][]{
            {1, 0},
            {1, 2},
            {3, 4},
            {4, 5},
            {5, 6},
            {5, 7},
            {7, 4},
            {8, 0}
        })));
    }
}