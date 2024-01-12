import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;
        // expand from 0 to MAX-DIS
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int dis = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 0) {
                    map.computeIfAbsent(dis, k->new HashSet<>()).add(i*N+j);
                }
            }
        }
        while (!map.isEmpty()) {
            Set<Integer> values = map.remove(dis);
            if (values == null) {
                dis++;
                continue;
            }
            for (Integer it : values) {
                if (set.contains(it)) {
                    continue;
                }
                int i = it / N;
                int j = it % N;
                mat[i][j] = dis;
                set.add(it);
                //
                if (i > 0) {
                    // up
                    map.computeIfAbsent(dis + 1, k -> new HashSet<>()).add((i - 1) * N + j);
                    if (j > 0) {
                        // up-left
                        map.computeIfAbsent(dis + 2, k -> new HashSet<>()).add((i - 1) * N + j - 1);
                    }
                }
                if (i < M - 1) {
                    // down
                    map.computeIfAbsent(dis + 1, k -> new HashSet<>()).add((i + 1) * N + j);
                    if (j < N - 1) {
                        // down-right
                        map.computeIfAbsent(dis + 2, k -> new HashSet<>()).add((i + 1) * N + j + 1);
                    }
                }
                if (j > 0) {
                    // left
                    map.computeIfAbsent(dis + 1, k -> new HashSet<>()).add(i * N + j - 1);
                    if (i < M - 1) {
                        // down-left
                        map.computeIfAbsent(dis + 2, k -> new HashSet<>()).add((i + 1) * N + j - 1);
                    }
                }
                if (j < N - 1) {
                    // right
                    map.computeIfAbsent(dis + 1, k -> new HashSet<>()).add(i * N + j + 1);
                    if (i > 0) {
                        // up-right
                        map.computeIfAbsent(dis + 2, k -> new HashSet<>()).add((i - 1) * N + j + 1);
                    }
                }

            }
            dis++;
        }
        return mat;    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[0,0,0],[0,1,0],[0,0,0]]
        System.out.println(s.updateMatrix(
                new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));
        // [[0,0,0],[0,1,0],[1,2,1]]
        System.out.println(s.updateMatrix(
                new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } }));
    }
}
