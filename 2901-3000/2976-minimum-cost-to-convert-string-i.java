import java.util.*;
/**
 * 2976-minimum-cost-to-convert-string-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/27
 */
public class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] graph = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < original.length; i++) {
            int a = original[i] - 'a';
            int b = changed[i] - 'a';
            if (graph[a][b] < 0) {
                graph[a][b] = cost[i];
            } else {
                graph[a][b] = Math.min(graph[a][b], cost[i]);
            }
        }
        // build graph
        for (int i = 0; i < graph.length; i++) { // row
            LinkedList<Integer> toCheck = new LinkedList<>();
            for (int j = 0; j < graph.length; j++) { // col
                if (graph[i][j] <= 0) {
                    continue;
                }
                toCheck.add(j);
            }
            while (!toCheck.isEmpty()) {
                int j = toCheck.poll();
                for (int k = 0; k < graph[j].length; k++) { // next row
                    if (graph[j][k] > 0) {
                        int d = graph[i][j] + graph[j][k];
                        if (graph[i][k] < 0 || graph[i][k] > d) {
                            graph[i][k] = d;
                            toCheck.add(k);
                        }
                    }
                }
            }
        }

        long total = 0L;
        for (int i = 0; i < source.length(); i++) {
            int a = source.charAt(i) - 'a';
            int b = target.charAt(i) - 'a';
            int c = graph[a][b];
            if (c < 0) {
                return -1;
            }
            total += c;
        }
        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 28
        System.out.println(s.minimumCost(
                    "abcd", "acbe",
                    new char[]{'a', 'b', 'c', 'c', 'e', 'd'},
                    new char[]{'b', 'c', 'b', 'e', 'b', 'e'},
                    new int[]{2,5,5,1,2,20}));
        // 12
        System.out.println(s.minimumCost(
                    "aaaa", "bbbb",
                    new char[]{'a', 'c'},
                    new char[]{'c', 'b'},
                    new int[]{1,2}));
    }
}

/**
new char[]{'z','u','z','i','z','y','w','e','m','b','u','l','l','u','e','s','n','s','m','b','p','y','w','v','m','y','l','b','h','i','y','b','o','l','u','i','e','v','o','w','p','a','z','u','i','o','b','w','m','b','n','a','y','y','v','a','v','m','s','m','v','n','e','m','o','h','p','n','w','s','y','n','w','y','u','m','a','y','s','m','n','e','w','e','u','m','m','z','z','z','v','i','w','s','y','v','i','a','y','m','y','b','p','e','v','z','y','p','a','m','b','y','s','o','n','w','n','h','m','z','u','n','b','e','v','s','o','z','z','b','y','i','w','n','l','s','y','i','w','b','u','e','i','u','m','m','w','b','i','s','m','p','v','u','u','w','m','a','l','m','w','s','u','p','w','m','h','n','s','s','v','e','u','z','v','e','u','a','l','p','l','y','n','p','u','m','b','l','h','s','a','y','s','n','p','m','m','v','u','b','l','u','u','b','m','o','b','p','a','y','l','w','i','y','i','e','m','m','n','s','o','z','u','h','v','b','u','b','i','u','p','z','w','z','s','o','m','p','w','z','n','n','l','n','p','m','y','u','e','n','m','h','y','m','h','m','n','p','l','i','u','a','v','l','l','z','e','n','o','b','o','v','y','n','i','v','h','a','e','b','p','l','m','h','y','b','y','n','m','h','p','u','o','p','w','b','e','o','o','a','o','a','i','m','w','v','y','e','e','l','e','a','m','w','p','b','a','o','s','z','z','s','p','v','v','i','b','v','u','n','w','y','a','h','a','l','y','a','v','o','h','v','u','e','y','m','n','a','u','n','w','m','m','y','e','o','l','b','p','e','w','m','i','s','z','i','z','u','y','b','z','m','v','n','p','u','m','n','m','p','v','b','s','w','l','b','n','o','z','w','p','e','u','m','z','h','b','u','h','z','e','v','l','p','v','z','n','z','h','i','p','w','o','y','l','n','h','w','b','m','l','a','i','w','a','w','a','l','a','n','b','n','u','b','b','p','v','o','m','o','n','b','i','o','u','v','p','y','m','l','n','p','u','h','p','s','s','n','w','p','m','n','b','z','p','m','z','b','z','v','n','v','s','a','b','s','y','a','b','h','z','y','m','p','e','n','h','y','s','n','n','n','i','i','u','p','s','b','w','y','w','l','z','n','p','e','b','a','n','y','z','b','s','o','i','p','m','w','h','h','i','m','o','b','v','u','w','i','m','a','e','e','p','o','a','w','o','h','m','i','p','u','e','a','m','s','p','w','y','b','e','v','w','i','v','z','l','l','o','y','s','v','m','a','b','m','m','a','h','u','n','z','h','n','u','w','a','p','m','a','a','s','z','l','e','a','u','i','z','e','u','p','v','n','b','o','w','p','p','z','a','l','z','m','h','b','w','u','b','v','h','u','w','a','o','z','m','m','z','u','l','l','m','y','y','a','i','n','v','z','o','v','e','h','n','y','a','u','n','n','a','o','s','i','y','m','v','w','b','p','s','b','s','y','o','w','v','v','u','b','a','z','a','o','w','n','e','s','l','z','s','o','l','i','i','z','p','n','w','u','h','m','z','b','w','p','a','i','a','o','u','v','z','l','a','w','a','b','y','i','i','b','u','o','s','h','m','b','h','a','y','p','m','b','a','b','s','m','m','m','y','m','l','m','y','m','s','b','s','u','b','e','s','n','w','v','p','p','z','p','w','h','z','u','z','p','i','u','n','v','o','n','y','e','i','o','b','b','b','v','y','o','b','m','n','v','i','h','y','i','i','w','v','l','p','o','v','z','s','y','l','w','n','a','i','i','m','u','w','i','b','n','w','v','i','z','o','u','n','e','o','v','u','b','e','o','v','a','i','e','v','m','a','p','z','a','o','p','m','m','e','l','h','w','m','i','w','w','v','v','e','e','n','l','h','u','o','p','p','p','h','l','o','p','w','n','a','u','o','w','s','i','l','e','n','l','b','m','m','v','s','w','b','b','e','i','a','m','v','u','u','i','v','i','v','l','e','l','h','a','s','n','b','o','p','y','i','a','i','z','u','o','z','u','e','l','n','e','b','p','h','s','e','o','a','v','e','o','v','i','u','i','e','y','h','p','o','e','y','v','p','i','u','n','e','l','y','b','v','e','p','b','o','y','m','m','p','s','y','m','n','p','m','o','a','n','v','b','b','a','w','e','u','e','h','p','s','w','w','y','m','p','o','a','y','y','i','i','s','z','a','o','y','i','u','i','b','a','u','s','n','s','u','v','u','e','h','h','v','u','s','s','o','m','b','b','m','z','u','l','o','w','n','y','h','w','a','e','m','p','o','e','p','o','o','p','i','u','l','u','m','y','u','p','z','b','l','n','p','i','e','o','w','y','u','e','w','b','e','s','w','a','e','u','o','v','z','u','n','i','p','b','w','m','o','u','u','m','y','a','w','s','m','l','u','l','z','o','p','v','e','z','p','b','v','s','p','l','y','p','v','b','i','n','v','h','n','l','z','i','i','y','a','s','b','b','n','u','m','a','u','v','i','u','u','n','w','w','n','m','v','a','n','a','z','h','i','z','w','u','y','z','s','h','l','h','b','u','o','u','b','n','l','b','y','l','b','z','s','p','z','l','w','z','a','v','z','m','m','o','n','b','w','a','u','o','u','z','e','h','h','m','v','l','b','y','b','n','p','v','z','w','w','o','v','m','l','l','y','b','y','p','z','o','y','m','a','m','s','w','n','y','w','y','v','v','u','b','y','a','b','y','n','h','w','z','s','y','w','s','i','p','b','y','v','l','p','y','v','y','s','a','u','l','b','u','i','m','e','b','i','b','y','e','i','l','v','i','l','o','p','a','z','o','a','u','p','b','p','m','h','p','v','z','o','i','n','p','p','w','i','y','y','a','y','z','o','v','y','m','s','p','y','o','b','w','v','v','b','s','s','v','s','u','v','m','a','a','u','v','z','v','p','b','i','w','v','l','m','e','e','b','z','n','v','p','i','b','l','i','h','h','o','v','u','p','b','i','w','b','u','l','m','l','i','p','b','n','a','e','z','b','p','z','o','y','n','e','n','z','b','m','v','e','e','w','a','s','l','m','s','l','i','z','i','m','v','w','m','i','v','m','n','w','m','n','u','w','m','e','e','i','n','o','i','n','o','s','n','o','h','p','l','m','n','i','u','z','u','e','a','w','a','w','b','m','h','z','n','z','y','u','s','b','p','p','s','m','y','s','y','h','e','h','l','n','l','l','w','s','v','m','i','h','n','n','a','m','i','s','h','b','u','y','p','v','m','b','b','p','b','h','n','n','i','a','b','o','l','w','a','m','m','y','v','z','w','a','n','e','a','e','m','y','v','p','a','a','z','l','a','o','a','u','y','p','y','y','l','b','h','y','u','m','y','v','m','w','a','s','e','o','m','m','z','i','y','v','n','o','p','v','i','v','b','w','v','p','a','m','h','l','o','b','u','y','y','u','n','u','z','b','e','h','e','z','a','u','m','z','m','s','y','z','l','m','m','n','m','m','i','a','v','b','s','a','l','v','n','l','i','s','z','w','n','l','l','b','p','e','e','b','h','m','b','e','w','w','b','l','i','y','b','s','o','l','h','n','v','v','e','v','s','o','a','m','v','m','u','s','v','y','b','a','v','s','a','b','p','i','v','y','v','p','p','b','a','z','l','a','w','l','l','u','b','v','z','u','p','m','h','s','b','n','y','o','z','b','b','n','n','s','m','p','u','u','s','m','s','z','n','y','u','s','w','e','u','z','o','u','n','i','o','l','v','s','o','z','z','n','u','w','n','v','w','s','a','h','v','z','u','h','y','o','u','p','i','p','o','w','n','b','o','o','e','v','m','s','h','z','z','a','o','n','h','s','v','l','o','v','y','m','m','m','l','z','w','e','e','p','m','l','m','e','s','e','a','i','z','i','l','y','s','h','u','y','n','h','u','u','a','l','a','a','n','a','b','a','h','u','y','m','o','m','h','a','e','u','z','l','s','s','u','s','o','y','b','y','s','o','e','m','y','e','z','b','n','w','u','v','n','y','y','i','p','l','u','p','u','e','m','l','n','i','p','o','e','s','y','v','m','u','i','e','u','p','z','e','b','m','b','u','w','v','i','n','h','a','z','l','s','e','b','m','b','v','b','z','b','h','o','o','l','b','o','l','w','z','e','w','e','p','n','y','w','o','m','h','v','o','a','u','u','e','h','z','y','e','e','i','v','m','b','a','w','l','p','p','s','v','u','n','u','a','s','w','h','n','m','b','l','m','v','a','i','s','w','u','o','l','u','h','h','n','o','n','m','l','o','w','e','h','i','v','w','l','h','p','m','o','s','p','y','n','m','p','v','w','w','p','v','u','p','n','m','s','l','p','e','z','w','p','i','u','e','s','l','m','n','n','l','a','m','p','n','h','a','e','m','h','v','y','u','l','a','a','l','m','v','l','n','o','n','z','e','a','p','s','n','m','s','n','a','h','n','l','h','l','z','m','y','o','m','y','u','l','s','p','l','v','n','a','o','w','b','e','a','w','w','w','z','s','b','u','s','e','e','p','m','y']
 */
