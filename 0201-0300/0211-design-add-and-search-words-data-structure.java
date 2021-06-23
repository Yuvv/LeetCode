import java.util.Map;
import java.util.HashMap;

/*
 * 0211-design-add-and-search-words-data-structure.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/06/22
 */
class WordDictionary {

    private Map<Character, WordDictionary> map;

    public WordDictionary getOrInsertByChar(char c) {
        if (map.containsKey(c)) {
            return map.get(c);
        } else {
            WordDictionary wd = new WordDictionary();
            map.put(c, wd);
            return wd;
        }
    }

    public WordDictionary getByChar(char c) {
        return map.get(c);
    }

    public void insertEnd() {
        map.put(null, null);
    }

    public boolean containsEnd() {
        return map.containsKey(null);
    }

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        map = new HashMap<>();
    }

    /**
     * Inserts a word into the trie.
     */
    public void addWord(String word) {
        WordDictionary that = this;
        for (char c : word.toCharArray()) {
            that = that.getOrInsertByChar(c);
        }
        that.insertEnd();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        WordDictionary that = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (that == null) {
                return false;
            } else if (c == '.') {
                for (WordDictionary wd : that.map.values()) {
                    if (wd != null && wd.search(word.substring(i + 1))) {
                        return true;
                    }
                }
                return false;
            }
            that = that.getByChar(c);
        }
        return that != null && that.containsEnd();
    }
}

public class Solution {

    public static void main(String[] args) throws Exception {

        Solution s = new Solution();

        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }
}