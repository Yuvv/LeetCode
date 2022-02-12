import java.util.*;
import java.util.stream.Collectors;

/*
 * 0127-word-ladder.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/02/12
 */
public class Solution {
    public boolean diffOne(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> map = new HashMap<>();
        boolean found = false;
        for (int i = 0; i < wordList.size(); i++) {
            String a = wordList.get(i);
            if (a.equals(endWord)) {
                found = true;
            }
            if (diffOne(beginWord, a)) {
                map.computeIfAbsent(beginWord, k -> new HashSet<>()).add(a);
            }
            for (int j = i + 1; j < wordList.size(); j++) {
                String b = wordList.get(j);
                if (diffOne(a, b)) {
                    map.computeIfAbsent(a, k -> new HashSet<>()).add(b);
                    map.computeIfAbsent(b, k -> new HashSet<>()).add(a);
                }
            }
        }
        if (!found) {
            return 0;
        }
        int len = 1;
        Set<String> candidate = new HashSet<>();
        candidate.add(beginWord);
        Set<String> alreadySeen = new HashSet<>(candidate);
        while (!candidate.isEmpty()) {
            candidate = candidate.stream()
                    .map(map::get)
                    .filter(Objects::nonNull)
                    .flatMap(Set::stream)
                    .collect(Collectors.toSet());
            candidate.removeAll(alreadySeen);
            len++;
            if (candidate.contains(endWord)) {
                return len;
            }
            alreadySeen.addAll(candidate);
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.ladderLength(
            "hit", "cog",
            Arrays.asList("hot","dot","dog","lot","log","cog")
        ));
        // 0
        System.out.println(s.ladderLength(
            "hit", "cog",
            Arrays.asList("hot","dot","dog","lot","log")
        ));
        // 0
        System.out.println(s.ladderLength(
            "hit", "cog",
            Arrays.asList("hot","dot","tog","cog")
        ));
    }
}