import java.util.*;

/*
 * 2707-extra-characters-in-a-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/09/02
 */
public class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        Trie tree = new Trie();
        for (String word : dictionary) {
            tree.insert(word);
        }

        return dfs(dp, s, 0, tree);
    }

    private int dfs(int[] dp, String s, int idx, Trie tree) {
        if (idx >= dp.length) {
            return 0;
        }
        if (dp[idx] >= 0) {
            return dp[idx];
        }
        int minLen = dp.length - idx;
        Trie that = tree;
        for (int i = idx; i < s.length(); i++) {
            that = that.getByChar(s.charAt(i));
            if (that == null) {
                // try next
                break;
            }
            if (that.containsEnd()) {
                minLen = Math.min(minLen, dfs(dp, s, i+1, tree));
            }
        }
        // whatever, try next
        minLen = Math.min(minLen, 1 + dfs(dp, s, idx+1, tree));

        dp[idx] = minLen;
        return minLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.minExtraChar("leetscode", new String[] {"leet", "code"}));
        // 3
        System.out.println(s.minExtraChar("sayhelloworld", new String[] {"hello", "world"}));
        // 9
        System.out.println(s.minExtraChar(
            "xiqdcejwkdsqjqryywpjisctstpguipj",
            new String[] {"tvnc","yejb","ry","ve","hr","t","vpjb","mixj","jfyei","ofiys","v","ce","jpfx","uc","jfv","u","a","tstpg","lmlcj","tdzmx","dlze","pjisc","dsq","iq","rpqlp","j","fllw","gz"}
        ));
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