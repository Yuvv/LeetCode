import java.util.LinkedList;

/*
 * 1032-stream-of-characters.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/04
 */
public class StreamChecker {

    private Trie root;
    private LinkedList<Character> stream;

    public StreamChecker(String[] words) {
        this.root = new Trie('\0');
        for (String word : words) {
            this.root.addWord(word);
        }
        this.stream = new LinkedList<>();
    }

    public boolean query(char letter) {
        this.stream.addFirst(letter);
        return this.root.findWord(this.stream);
    }
}

class Trie {
    char val;
    boolean hasEnd;
    Trie[] nexts;

    public Trie(char a) {
        this.val = a;
        this.hasEnd = false;
        this.nexts = new Trie[26];
    }

    public void addWord(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }

        Trie node = this;
        for (int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            int idx = ch - 'a';
            if (node.nexts[idx] == null) {
                node.nexts[idx] = new Trie(ch);
            }
            node = node.nexts[idx];
        }
        node.hasEnd = true;
    }

    public boolean findWord(LinkedList<Character> stream) {
        Trie node = this;
        for (Character ch : stream) {
            if (node == null) {
                return false;
            } else if (node.hasEnd) {
                return true;
            }
            node = node.nexts[ch - 'a'];
        }
        return node != null && node.hasEnd;
    }
}