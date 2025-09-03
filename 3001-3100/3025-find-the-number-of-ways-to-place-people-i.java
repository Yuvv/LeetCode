import java.util.*;
/**
 * 3025-find-the-number-of-ways-to-place-people-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/09/04
 */
public class Solution {
    public int numberOfPairs(int[][] points) {
             // build x-y map
        TreeMap<Integer, TreeSet<Integer>> xMap = new TreeMap<>();
        TreeMap<Integer, TreeSet<Integer>> yMap = new TreeMap<>();
        for (int[] pt : points) {
            xMap.computeIfAbsent(pt[0], k -> new TreeSet<>()).add(pt[1]);
            yMap.computeIfAbsent(pt[1], k -> new TreeSet<>()).add(pt[0]);
        }
        //
        int cnt = 0;
        for (int[] pt : points) {
            // left
            Integer leftX = yMap.get(pt[1]).lower(pt[0]);
            if (leftX != null) {
                cnt++;
            } else {
                leftX = -1; // 0 <= pt
            }
            // up
            Integer upY = xMap.get(pt[0]).higher(pt[1]);
            if (upY != null) {
                cnt++;
            } else {
                upY = 51;  // pt <= 50
            }
            // left-up
            Map.Entry<Integer, TreeSet<Integer>> lowXEntry = xMap.lowerEntry(pt[0]);
            while (lowXEntry != null) {
                if (lowXEntry.getKey().compareTo(leftX) <= 0) {
                    break;
                }
                Integer hy = lowXEntry.getValue().higher(pt[1]);
                if (hy != null) {
                    if (hy.compareTo(upY) < 0) {
                        cnt++;
                        upY = hy;
                    }
                }
                lowXEntry = xMap.lowerEntry(lowXEntry.getKey());
            }

        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 9
        System.out.println(s.numberOfPairs(
                as2dIntArray("[[4, 6], [3, 10], [0, 7], [2, 1], [5, 4], [6, 10], [1, 3], [3, 8], [0, 5]]")
        ));
        // 2
        System.out.println(s.numberOfPairs(
                as2dIntArray("[[0,1],[1,3],[6,1]]")
        ));
        // 9
        System.out.println(s.numberOfPairs(
                as2dIntArray("[[3,1],[1,4],[1,5],[1,6],[1,3],[1,1],[2,1],[4,1],[2,2]]")
        ));
    }

    static int[][] as2dIntArray(String s) {
        // [[1,8],[3,-2]]
        s = s.trim();
        if (s.charAt(0) != '[' || s.charAt(s.length() - 1) != ']') {
            throw new IllegalArgumentException("not as [...]");
        }
        s = s.substring(1, s.length() - 1);
        s = s.trim();
        if (s.charAt(0) != '[' || s.charAt(s.length() - 1) != ']') {
            throw new IllegalArgumentException("not as [...]");
        }

        s = s.substring(1, s.length() - 1);
        String[] rows = s.split("]\\s*,\\s*\\[");
        int[][] res = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String[] values = rows[i].split(",");
            res[i] = Arrays.stream(values).map(String::trim).mapToInt(Integer::parseInt).toArray();
        }
        return res;
    }
}