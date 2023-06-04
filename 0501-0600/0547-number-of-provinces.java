import java.util.*;

/*
 * 0547-number-of-provinces.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/06/04
 */
public class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] dsu = new int[isConnected.length];
        Arrays.fill(dsu, -1);
        // bfs
        for (int i = 0; i < isConnected.length; i++) {
            LinkedList<Integer> next = new LinkedList<>();
            if (dsu[i] < 0) {
                next.add(i);
            }
            while (!next.isEmpty()) {
                //
                int x = next.poll();
                dsu[x] = i;
                //
                for (int j = 0; j < isConnected[x].length; j++) {
                    if (dsu[j] < 0 && isConnected[x][j] == 1) {
                        next.push(j);
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int d : dsu) {
            set.add(d);
        }
        return set.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.findCircleNum(
            new int[][] {
                {1,1,0}, {1,1,0},{0,0,1}
            }
        ));
        // 3
        System.out.println(s.findCircleNum(
            new int[][] {
                {1,0,0}, {0,1,0},{0,0,1}
            }
        ));
    }
}