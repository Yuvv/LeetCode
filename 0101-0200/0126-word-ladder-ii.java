import java.util.*;
import java.util.stream.Collectors;

/*
 * 0126-word-ladder-ii.java
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

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
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
            return new ArrayList<>(0);
        }
        LinkedList<List<String>> candidate = new LinkedList<>();
        candidate.add(Arrays.asList(beginWord));
        Set<String> alreadySeen = new HashSet<>();
        alreadySeen.add(beginWord);
        while (!candidate.isEmpty()) {
            Set<String> levelSeen = new HashSet<>();
            ListIterator<List<String>> it = candidate.listIterator();
            found = false;
            while (it.hasNext()) {
                List<String> list = it.next();
                it.remove();
                String last = list.get(list.size() - 1);
                if (map.containsKey(last)) {
                    for (String next : map.get(last)) {
                        if (!alreadySeen.contains(next) && !list.contains(next)) {
                            levelSeen.add(next);
                            List<String> nl = new ArrayList<>(list);
                            nl.add(next);
                            it.add(nl);
                        }
                        if (next.equals(endWord)) {
                            found = true;
                        }
                    }
                }
            }
            if (found) {
                candidate.removeIf(l -> !l.get(l.size() - 1).equals(endWord));
                return candidate;
            }
            alreadySeen.addAll(levelSeen);
        }

        return new ArrayList<>(0);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
        System.out.println(s.findLadders(
            "hit", "cog",
            Arrays.asList("hot","dot","dog","lot","log","cog")
        ));
        // []
        System.out.println(s.findLadders(
            "hit", "cog",
            Arrays.asList("hot","dot","dog","lot","log")
        ));
        // []
        System.out.println(s.findLadders(
            "hit", "cog",
            Arrays.asList("hot","dot","tog","cog")
        ));
    }
}