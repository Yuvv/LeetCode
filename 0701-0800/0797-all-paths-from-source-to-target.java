import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/*
 * 0797-all-paths-from-source-to-target.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/13
 */
class Solution {
    private List<List<Integer>> resultList;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        resultList = new ArrayList<>();
        // dag walk
        List<Integer> curList = new ArrayList<>(Collections.singletonList(0));
        allPathsSourceTarget(graph, curList);

        return resultList;
    }

    public void allPathsSourceTarget(int[][] graph, List<Integer> curList) {
        int fromIndex = curList.get(curList.size() - 1);
        if (fromIndex == graph.length - 1) {
            resultList.add(curList);
            return;
        }
        int[] edges = graph[fromIndex];
        for (int nextPoint : edges) {
            List<Integer> list = new ArrayList<>(curList);
            list.add(nextPoint);
            allPathsSourceTarget(graph, list);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[0,1,3],[0,2,3]]
        System.out.println(s.allPathsSourceTarget(new int[][] {
            new int[]{1,2},
            new int[]{3},
            new int[]{3},
            new int[]{}
        }));
        // [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
        System.out.println(s.allPathsSourceTarget(new int[][] {
            new int[]{4,3,1},
            new int[]{3,2,4},
            new int[]{3},
            new int[]{4},
            new int[]{}
        }));
    }
}