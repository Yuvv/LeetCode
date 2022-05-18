import java.util.*;
import java.util.stream.*;

/*
 * 0395-longest-substring-with-at-least-k-repeating-characters.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/18
 */
public class Solution {
    public int longestSubstring(String s, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(String::length).reversed());
        pq.add(s);

        int maxLen = 0;
        while (!pq.isEmpty()) {
            String candidate = pq.poll();
            if (candidate.length() <= maxLen) {
                continue;
            }
            Map<Character, Integer> chCountMap = new HashMap<>();
            for (int i = 0; i < candidate.length(); i++) {
                char ch = candidate.charAt(i);
                chCountMap.put(ch, chCountMap.getOrDefault(ch, 0) + 1);
            }
            String invalidChs = chCountMap.entrySet().stream()
                .filter(e -> e.getValue() < k)
                .map(Map.Entry::getKey)
                .map(Objects::toString)
                .collect(Collectors.joining());
            if (invalidChs.length() == 0) {
                maxLen = Math.max(maxLen, candidate.length());
            } else {
                for (String next : candidate.split("[" + invalidChs + "]+")) {
                    pq.add(next);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.longestSubstring("aaabb", 3));
        // 5
        System.out.println(s.longestSubstring("ababbc", 2));
    }
}