import java.util.*;

/**
 * 2045-second-minimum-time-to-reach-destination.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/28
 */
public class Solution {
    public int secondMinimum(int N, int[][] edges, int time, int change) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] e : edges) {
            graph.computeIfAbsent(e[0], k -> new HashSet<>()).add(e[1]);
            graph.computeIfAbsent(e[1], k -> new HashSet<>()).add(e[0]);
        }
        LinkedList<Node> queue = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        queue.addLast(new Node(1, 0));
        int[] visited = new int[N + 1];
        visited[1] = 1;
        int[] minTime = new int[N + 1];
        Arrays.fill(minTime, -1);
        minTime[1] = 0;
        while (!queue.isEmpty()) {  // bfs
            Node node = queue.poll();
            if (node.time > 0 && node.time >= smin) {
                continue;
            }
            Set<Integer> nextSet = graph.get(node.n);
            if (nextSet != null) {
                for (Integer next : nextSet) {
                    Node nextNode = node.moveNext(next, time);
                    if (nextNode.n == N) {
                        if (nextNode.time < min) {
                            smin = min;
                            min = nextNode.time;
                        } else if (nextNode.time > min && nextNode.time < smin) {
                            smin = nextNode.time;
                        }
                    }
                    nextNode.waitGreen(change);
                    if (visited[next] < 2 && nextNode.time > minTime[next]) {
                        minTime[next] = nextNode.time;
                        visited[next]++;
                        queue.addLast(nextNode);
                    }
                }
            }
        }
        return smin;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 13
        System.out.println(s.secondMinimum(
            5, new int[][]{{1,2},{1,3},{1,4},{3,4},{4,5}}, 3, 5
        ));
        // 11
        System.out.println(s.secondMinimum(
            2, new int[][]{{1,2}}, 3, 2
        ));
    }
}

class Node {
    int n;
    int time;

    public Node(int n, int time) {
        this.n = n;
        this.time = time;
    }

    public Node moveNext(int n, int timeSpend) {
        return new Node(n, this.time + timeSpend);
    }

    public void waitGreen(int timeChange) {
        int st = this.time / timeChange;
        if (st % 2 == 1) {
            this.time = (st + 1) * timeChange;
        }
    }

    @Override
    public String toString() {
        return "Node(n=" + n + ", time=" + time + ")";
    }
}
