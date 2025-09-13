import java.util.*;
/**
 * 1733-minimum-number-of-people-to-teach.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/09/13
 */
public class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> notConnected = new HashSet<>();
        for (int[] fs : friendships) {
            int i = fs[0] - 1;
            int j = fs[1] - 1;
            Set<Integer> xSet = new HashSet<>(languages[i].length);
            for (int l : languages[i]) {
                xSet.add(l);
            }
            boolean find = false;
            for (int l : languages[j]) {
                if (xSet.contains(l)) {
                    find = true;
                    break;
                }
            }
            if (!find) {
                notConnected.add(i);
                notConnected.add(j);
            }
        }
        int cnt = 0;
        int[] cntarr = new int[n+1];
        for (int fs : notConnected) {
            for (int l : languages[fs]) {
                cntarr[l]++;
                cnt = Math.max(cnt, cntarr[l]);
            }
        }
        return notConnected.size() - cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.minimumTeachings(
            2, new int[][]{{1}, {2}, {1,2}}, new int[][]{{1,2}, {1,3}, {2,3}}
        ));
        // 2
        System.out.println(s.minimumTeachings(
            3, new int[][]{{2}, {1,3}, {1,2}, {3}}, new int[][]{{1,4}, {1,2}, {3,4}, {2,3}}
        ));
    }
}