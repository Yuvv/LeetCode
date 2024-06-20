import java.util.*;

/**
 * 1552-magnetic-force-between-two-balls.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/20
 */
public class Solution {
    public int maxDistance(int[] position, int m) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int p : position) {
            treeSet.add(p);
        }
        int cand = -1;
        int min = 1;
        int max = treeSet.last();
        while (min <= max) {
            int mid = (min + max) / 2;
            // check
            boolean ok = true;
            Integer x = treeSet.first();
            for (int i = 1; i < m; i++) {
                x = treeSet.higher(x+mid-1);
                if (x == null) {
                    ok = false;
                    break;
                }
            }
            System.out.println("ok="+ok + ", min=" + min + ", max=" + max + ", mid=" + mid);
            if (ok) {
                cand = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return cand;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.maxDistance(new int[] {1,2,3,4,7}, 3));
        // 2
        System.out.println(s.maxDistance(new int[] {5,4,3,2,1,1000000000}, 2));
    }
}