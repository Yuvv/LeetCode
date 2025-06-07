import java.util.*;
/**
 * 3170-lexicographically-minimum-string-after-removing-stars.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/06/07
 */
public class Solution {
    public String clearStars(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];  // character Asc
            }
            return b[1] - a[1];   // index Desc
        });
        Set<Integer> removedIndices = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                if (!pq.isEmpty()) {
                    int[] x = pq.poll();
                    removedIndices.add(x[1]);
                }
            } else {
                pq.offer(new int[]{s.charAt(i), i});
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (removedIndices.contains(i)) {
                continue;
            }
            char ch = s.charAt(i);
            if (ch != '*') {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "aab"
        System.out.println(s.clearStars("aaba*"));
        // "abc"
        System.out.println(s.clearStars("abc"));
    }
}