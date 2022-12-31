import java.util.*;

/*
 * 0955-delete-columns-to-make-sorted-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/12/31
 */
public class Solution {
    public int minDeletionSize(String[] strs) {
        int cnt = 0;

        Set<int[]> toCheckColumnPairs = new HashSet<>();
        for (int i = 1; i < strs.length; i++) {
            toCheckColumnPairs.add(new int[]{i-1, i});
        }

        for (int i = 0; i < strs[0].length(); i++) {
            if (toCheckColumnPairs.isEmpty()) {
                break;
            }
            boolean ok = true;
            List<int[]> toRemovePairs = new ArrayList<>();
            for (int[] pair : toCheckColumnPairs) {
                char a = strs[pair[0]].charAt(i);
                char b = strs[pair[1]].charAt(i);
                if (a > b) {
                    cnt++;
                    ok = false;
                    break;
                } else if (a < b) {
                    toRemovePairs.add(pair);
                }
            }
            if (ok) {
                toCheckColumnPairs.removeAll(toRemovePairs);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.minDeletionSize(
            new String[] {"ca", "bb", "ac"}
        ));
        // 0
        System.out.println(s.minDeletionSize(
            new String[] {"xc", "yb", "za"}
        ));
        // 3
        System.out.println(s.minDeletionSize(
            new String[] {"zyx", "wvu", "tsr"}
        ));
    }
}