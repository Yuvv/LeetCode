import java.util.*;

/**
 * 0648-replace-words.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/07
 */
public class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie root = new Trie(' ');
        for (String each : dictionary) {
            root.addWord(each);
        }
        StringBuilder sb = new StringBuilder();
        for (String each : sentence.split(" ")) {
            String w = root.findWordRoot(each);
            sb.append(w);
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "the cat was rat by the bat"
        System.out.println(s.replaceWords(
            Arrays.asList("cat", "bat", "rat"),
            "the cattle was rattled by the battery"
        ));
        // "a a b c"
        System.out.println(s.replaceWords(
            Arrays.asList("a", "b", "c"),
            "aadsfasf absbs bbbab cadfjkal"
        ));
    }
}

class Trie {
    char ch;
    Map<Character, Trie> next;
    boolean hasEnd;

    public Trie(char ch) {
        this.ch = ch;
        this.next = new HashMap<>();
    }

    public void addWord(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char chr = word.charAt(i);
            Trie next = node.next.get(chr);
            if (next == null) {
                next = new Trie(chr);
                node.next.put(chr, next);
            }
            node = next;
        }
        node.hasEnd = true;
    }

    public String findWordRoot(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char chr = word.charAt(i);
            if (!node.next.containsKey(chr)) {
                return word;
            }
            node = node.next.get(chr);
            if (node.hasEnd) {
                return word.substring(0, i+1);
            }
        }
        return word;
    }
}