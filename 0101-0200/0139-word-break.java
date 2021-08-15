import java.util.*;

/*
 * 0139-word-break.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/15
 */
public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict.size());
        Set<Integer> sizeSet = new HashSet<>(wordDict.size());
        for (String word : wordDict) {
            sizeSet.add(word.length());
            wordSet.add(word);
        }

        int len = s.length();
        boolean[] table = new boolean[len+1];
        table[0] = true;
        for (int i = 1; i <= len; i++) {
            for (Integer size : sizeSet) {
                if (i >= size && wordSet.contains(s.substring(i - size, i))) {
                    table[i] = table[i-size];
                    if (table[i]) {
                        break;
                    }
                }
            }
        }

        return table[len];
    }

    public static void main(String[] args) throws Exception {

        Solution s = new Solution();
        // true
        System.out.println(s.wordBreak("leetcode", Arrays.asList("leetcode")));
        // false
        System.out.println(s.wordBreak("leetcode", Arrays.asList("leetcode1")));
        // true
        System.out.println(s.wordBreak("leetcode", Arrays.asList("leet", "code")));
        // true
        System.out.println(s.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        // false
        System.out.println(s.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        // false
        System.out.println(s.wordBreak(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }
}

class Trie {

    private Map<Character, Trie> map;

    public Trie getOrInsertByChar(char c) {
        if (map.containsKey(c)) {
            return map.get(c);
        } else {
            Trie trie = new Trie();
            map.put(c, trie);
            return trie;
        }
    }

    public Trie getByChar(char c) {
        return map.get(c);
    }

    public void insertEnd() {
        map.put(null, null);
    }

    public boolean containsEnd() {
        return map.containsKey(null);
    }

    /** Initialize your data structure here. */
    public Trie() {
        map = new HashMap<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie that = this;
        for (char c: word.toCharArray()) {
            that = that.getOrInsertByChar(c);
        }
        that.insertEnd();
    }
}