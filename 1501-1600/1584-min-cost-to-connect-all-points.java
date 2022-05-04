import java.util.*;

/*
 * 1584-min-cost-to-connect-all-points.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/27
 */
public class Solution {
    /**
     * Kruskal's Algorithm
     * Time: O(N^2 log(N))
     * Space: O(N^2)
     */
    public int minCostConnectPoints(int[][] points) {
        List<int[]> allEdges = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int weight = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                allEdges.add(new int[] {weight, i, j});
            }
        }
        // sort all edges by weight
        allEdges.sort(Comparator.comparingInt(a -> a[0]));

        UnionFind uf = new UnionFind(points.length);
        int mstCost = 0;
        int edgesUsed = 0;
        for (int[] pt : allEdges) {
            if (uf.union(pt[1], pt[2])) {
                mstCost += pt[0];
                edgesUsed++;
            }
            if (edgesUsed >= points.length - 1) {
                // means already the MST. `n` vertex needs `n - 1` edge at least to build MST
                break;
            }
        }
        return mstCost;
    }

    /**
     * Prime's Algorithm
     * Time: O(N^2)
     * Space: O(N^2)
     */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int mstCost = 0;
        int edgesUsed = 0;

        // Track nodes which are visited.
        boolean[] inMST = new boolean[n];

        int[] minDist = new int[n];
        minDist[0] = 0;

        for (int i = 1; i < n; ++i) {
            minDist[i] = Integer.MAX_VALUE;
        }

        while (edgesUsed < n) {
            int currMinEdge = Integer.MAX_VALUE;
            int currNode = -1;

            // Pick least weight node which is not in MST.
            for (int node = 0; node < n; ++node) {
                if (!inMST[node] && currMinEdge > minDist[node]) {
                    currMinEdge = minDist[node];
                    currNode = node;
                }
            }

            mstCost += currMinEdge;
            edgesUsed++;
            inMST[currNode] = true;

            // Update adjacent nodes of current node.
            for (int nextNode = 0; nextNode < n; ++nextNode) {
                int weight = Math.abs(points[currNode][0] - points[nextNode][0]) +
                             Math.abs(points[currNode][1] - points[nextNode][1]);

                if (!inMST[nextNode] && minDist[nextNode] > weight) {
                    minDist[nextNode] = weight;
                }
            }
        }

        return mstCost;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 20
        System.out.println(s.minCostConnectPoints(
            new int[][] {
                {0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}
            }
        ));
        // 18
        System.out.println(s.minCostConnectPoints(
            new int[][] {
                {3, 12}, {-2, 5}, {-4, 1}
            }
        ));
    }
}

class UnionFind {
    int[] group;
    int[] rank;

    public UnionFind(int size) {
        group = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            group[i] = i;
        }
    }

    public int find(int node) {
        if (group[node] != node) {
            // 每次都要重新找一遍，并赋值回去，防止在中间过程中，root 有更新
            group[node] = find(group[node]);
        }
        return group[node];
    }

    public boolean union(int node1, int node2) {
        int group1 = find(node1);
        int group2 = find(node2);

        if (group1 == group2) {
            // already exists
            return false;
        }

        if (rank[group1] > rank[group2]) {
            group[group2] = group1;
        } else if (rank[group1] < rank[group2]) {
            group[group1] = group2;
        } else {
            // choose any one when rank equals
            group[group1] = group2;
            rank[group2]++;
        }
        return true;
    }
}