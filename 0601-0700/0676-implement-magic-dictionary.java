import java.util.*;

/*
 * 0676-implement-magic-dictionary.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/20
 */
public class MagicDictionary {

    private Trie root;

    public MagicDictionary() {
        this.root = new Trie('\0');
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            root.add(word);
        }
    }

    public boolean search(String searchWord) {
        return root.magicFind(searchWord);
    }

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[] {"hello", "leetcode"});
        System.out.println(magicDictionary.search("hello")); // return False
        System.out.println(magicDictionary.search("hhllo")); // We can change the second 'h' to 'e' to match "hello" so we return True
        System.out.println(magicDictionary.search("hell")); // return False
        System.out.println(magicDictionary.search("leetcodd")); // return False
    }
}

class Trie {
    char val;
    boolean hasEnd;
    Map<Character, Trie> nexts;

    public Trie(char ch) {
        this.val = ch;
        this.hasEnd = false;
        this.nexts = new HashMap<>();
    }

    public void add(String s) {
        Trie node = this;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            node = node.nexts.computeIfAbsent(ch, Trie::new);
        }
        node.hasEnd = true;
    }

    public boolean magicFind(String s) {
        return magicFind(s, 0, false);
    }

    private boolean magicFind(String s, int fromIdx, boolean alreadyChanged) {
        char ch = s.charAt(fromIdx);
        Trie next = nexts.get(ch);
        if (fromIdx == s.length() - 1) {
            if (next != null && alreadyChanged && next.hasEnd) {
                return true;
            }
            if (!alreadyChanged) {
                for (Map.Entry<Character, Trie> entry : nexts.entrySet()) {
                    if (entry.getKey().compareTo(ch) != 0 && entry.getValue().hasEnd) {
                        return true;
                    }
                }
            }
            return false;
        }
        boolean res = false;
        if (next != null) {
            res = next.magicFind(s, fromIdx + 1, alreadyChanged);
        }
        if (!res && !alreadyChanged) {
            // try change one character
            for (Map.Entry<Character, Trie> entry : nexts.entrySet()) {
                if (entry.getKey().compareTo(ch) != 0 && !res) {
                    res = entry.getValue().magicFind(s, fromIdx + 1, true);
                }
            }
        }

        return res;
    }
}