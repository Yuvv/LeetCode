import java.util.Map;
import java.util.HashMap;

/*
 * 0208-implement-trie-prefix-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/06/20
 */
public class Trie {

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

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie that = this;
        for (char c: word.toCharArray()) {
            if (that == null) {
                return false;
            }
            that = that.getByChar(c);
        }
        return that.containsEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie that = this;
        for (char c: prefix.toCharArray()) {
            if (that == null) {
                return false;
            }
            that = that.getByChar(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */