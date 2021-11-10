import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

/*
 * 1178-number-of-valid-words-for-each-puzzle.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/09
 */
public class Solution {
    public List<Integer> findNumOfValidWords_tle(String[] words, String[] puzzles) {
        List<Integer> wordList = Stream.of(words)
                .map(s -> {
                    int res = 0;
                    Set<Character> set = new HashSet<>();
                    for (int i = 0; i < s.length(); i++) {
                        char ch = s.charAt(i);
                        res |= 1 << (ch - 'a');
                        set.add(ch);
                    }
                    if (set.size() > 7) {
                        return null;
                    }
                    return res;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        Set<Character> firstCharSet = Stream.of(puzzles)
                .map(s -> s.charAt(0))
                .collect(Collectors.toSet());
        Map<Character, List<Integer>> wordMapByChar = new HashMap<>();
        for (Integer word : wordList) {
            for (Character ch : firstCharSet) {
                if ((word & (1 << (ch - 'a'))) > 0) {
                    wordMapByChar.computeIfAbsent(ch, k -> new ArrayList<>()).add(word);
                }
            }
        }
        return Stream.of(puzzles)
                .map(s -> {
                    int cnt = 0;
                    int res = 0;
                    for (int i = 0; i < s.length(); i++) {
                        char ch = s.charAt(i);
                        res |= 1 << (ch - 'a');
                    }
                    for (Integer word : wordMapByChar.getOrDefault(s.charAt(0), Collections.emptyList())) {
                        if ((word & res) == word) {
                            cnt++;
                        }
                    }
                    return cnt;
                }).collect(Collectors.toList());
    }

    public int buildMask(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            res |= 1 << (ch - 'a');
            set.add(ch);
        }
        if (set.size() > 7) {
            return 0;
        }
        return res;
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> wordMap = Stream.of(words)
                .map(s -> buildMask(s))
                .filter(Objects::nonNull)
                .filter(i -> i > 0)
                .collect(Collectors.toMap(Function.identity(), i -> 1, Integer::sum));

        return Stream.of(puzzles)
                .map(s -> {
                    int res = buildMask(s.substring(1));
                    int firstCh = 1 << (s.charAt(0) - 'a');
                    int cnt = wordMap.getOrDefault(firstCh, 0);
                    for (int submask = res; submask > 0; submask = res & (submask - 1)) {
                        cnt += wordMap.getOrDefault(submask | firstCh, 0);
                    }
                    return cnt;
                }).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,1,3,2,4,0]
        System.out.println(s.findNumOfValidWords(
            new String[] {"aaaa","asas","able","ability","actt","actor","access"},
            new String[] {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"}
        ));
        // [0,1,3,2,0]
        System.out.println(s.findNumOfValidWords(
            new String[] {"apple","pleas","please"},
            new String[] {"aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"}
        ));
    }
}