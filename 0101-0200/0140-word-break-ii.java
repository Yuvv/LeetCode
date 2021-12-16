import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/*
 * 0140-word-break-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/16
 */
public class Solution {
    List<String> resList;
    Trie root;
    public List<String> wordBreak(String s, List<String> wordDict) {
        // build trie
        root = new Trie('\0');
        for (String word : wordDict) {
            root.addWord(word);
        }
        // build result
        resList = new ArrayList<>();
        dfs(s, 0, new StringBuilder());
        return resList;
    }

    public void dfs(String s, int i, StringBuilder sb) {
        if (i >= s.length()) {
            sb.deleteCharAt(sb.length() - 1);
            resList.add(sb.toString());
            return;
        }
        Trie node = root;
        for (int j = i; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (!node.next.containsKey(ch)) {
                return;
            }
            sb.append(ch);
            node = node.next.get(ch);
            if (node.hasEnd) {
                int len = sb.length();
                sb.append(' ');
                dfs(s, j + 1, sb);
                sb.delete(len, sb.length());
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ["cats and dog","cat sand dog"]
        System.out.println(s.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        // ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
        System.out.println(s.wordBreak("pineapplepenapple", Arrays.asList("apple","pen","applepen","pine","pineapple")));
        // []
        System.out.println(s.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }
}

class Trie {
    char val;
    boolean hasEnd;
    Map<Character, Trie> next;

    public Trie(char ch) {
        val = ch;
        hasEnd = false;
        next = new HashMap<>();
    }

    public void addWord(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            node = node.next.computeIfAbsent(ch, k -> new Trie(k));
        }
        node.hasEnd = true;
    }
}