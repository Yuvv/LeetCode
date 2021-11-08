import java.util.*;

/*
 * 0207-course-schedule.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/08
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> preReqMap = new HashMap<>(prerequisites.length);
        for (int[] req : prerequisites) {
            preReqMap.computeIfAbsent(req[0], k -> new HashSet<>()).add(req[1]);
        }
        Set<Integer> set = new HashSet<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            if (set.contains(i)) {
                continue;
            }
            if (preReqMap.containsKey(i)) {
                // has pre-requisite
                if (!dfs(preReqMap, i, set, new HashSet<>())) {
                    return false;
                }
            } else {
                // no pre-requisite
                set.add(i);
            }
        }
        return true;
    }

    public boolean dfs(Map<Integer, Set<Integer>> preReqMap, int i, Set<Integer> set, Set<Integer> chainSet) {
        if (set.contains(i)) {
            return true;
        }
        if (!preReqMap.containsKey(i)) {
            set.add(i);
            return true;
        }
        for (Integer j : preReqMap.get(i)) {
            if (chainSet.contains(j)) {
                return false;
            }
            chainSet.add(j);
            if (!dfs(preReqMap, j, set, chainSet)) {
                return false;
            }
            chainSet.remove(j);
        }
        set.add(i);
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.canFinish(2, new int[][]{{1,0}}));
        // false
        System.out.println(s.canFinish(2, new int[][]{{1,0},{0,1}}));
        // false
        System.out.println(s.canFinish(3, new int[][]{{1,0},{0,1},{1,2}}));
    }
}