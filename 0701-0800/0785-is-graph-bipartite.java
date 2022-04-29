/*
 * 0785-is-graph-bipartite.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/29
 */
public class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] us1 = new int[graph.length];
        int[] us2 = new int[graph.length];

        return depart(graph, 0, us1, us2);
    }

    private int tryPut(int[] row, int[] currentUs, int[] toUs) {
        int i;
        for (i = 0; i < row.length; i++) {
            if (currentUs[row[i]] > 0) {
                // 当前 us 里面有应该放到 toUs 里面的值，说明不合法，后续需要回滚
                return i;
            }
            toUs[row[i]]++;
        }
        return i;
    }

    private void rollbackPut(int[] row, int[] toUs, int endIdx) {
        for (int i = 0; i < Math.min(endIdx, row.length); i++) {
            toUs[row[i]]--;
        }
    }

    public boolean depart(int[][] graph, int currentNode, int[] us1, int[] us2) {
        if (currentNode >= graph.length) {
            return true;
        }
        if (graph[currentNode].length == 0) {
            return depart(graph, currentNode + 1, us1, us2);
        }
        boolean ok = false;
        boolean any = us1[currentNode] == 0 && us2[currentNode] == 0;
        if (us1[currentNode] > 0 || any) {
            // node already in us1, then put others to us2
            us1[currentNode]++;
            int putIdx = tryPut(graph[currentNode], us1, us2);
            if (putIdx < graph[currentNode].length || !depart(graph, currentNode + 1, us1, us2)) {
                // rollback
                us1[currentNode]--;
                rollbackPut(graph[currentNode], us2, putIdx + 1);
            } else {
                ok = true;
            }
        }
        if (ok) {
            return true;
        }
        if (us2[currentNode] > 0 || any) {
            // node already in us2, then put others to us1
            us2[currentNode]++;
            int putIdx = tryPut(graph[currentNode], us2, us1);
            if (putIdx < graph[currentNode].length || !depart(graph, currentNode + 1, us1, us2)) {
                // rollback
                us2[currentNode]--;
                rollbackPut(graph[currentNode], us1, putIdx + 1);
            } else {
                ok = true;
            }
        }
        return ok;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // false
        System.out.println(s.isBipartite(new int[][]  {
            {}, {2,4,6}, {1,4,8,9}, {7,8}, {1,2,8,9},
            {6,9}, {1,5,7,8,9}, {3,6,9}, {2,3,4,6,9},
            {2,4,5,6,7,8}
        }));
        // false
        System.out.println(s.isBipartite(new int[][] {
            {1,2,3}, {0,2}, {0,1,3}, {0,2}
        }));
        // true
        System.out.println(s.isBipartite(new int[][]  {
            {1,3}, {0,2}, {1,3}, {0,2}
        }));
        // true
        System.out.println(s.isBipartite(new int[][]  {
            {3}, {2,4}, {1}, {0,4}, {1,3}
        }));
    }
}

/*

[[1,2,3],[0,2],[0,1,3],[0,2]]
[[1,3],[0,2],[1,3],[0,2]]
[[1,3],[0,2],[1,3],[0,2],[],[6],[5]]
[[1],[0,3],[3],[1,2]]
[[3],[2,4],[1],[0,4],[1,3]]
[[],[2,4,6],[1,4,8,9],[7,8],[1,2,8,9],[6,9],[1,5,7,8,9],[3,6,9],[2,3,4,6,9],[2,4,5,6,7,8]]

 */