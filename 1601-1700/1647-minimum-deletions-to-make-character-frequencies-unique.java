import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * 1647-minimum-deletions-to-make-character-frequencies-unique.java
 *
 * @date 2024/1/28
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public int minDeletions(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)-'a']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 25; i >= 0; i--) {
            if (cnt[i] > 0) {
                pq.add(cnt[i]);
            }
        }
        int toDelete = 0;
        int last = pq.poll();
        while (!pq.isEmpty()) {
            int current = pq.poll();
            if (current == last) {
                toDelete++;
                current--;
                if (current > 0) {
                    pq.add(current);
                }
            } else {
                last = current;
            }
        }
        return toDelete;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0
        System.out.println(s.minDeletions("aab"));
        // 2
        System.out.println(s.minDeletions("aaabbbcc"));
        // 2
        System.out.println(s.minDeletions("ceabaacb"));
    }
}
