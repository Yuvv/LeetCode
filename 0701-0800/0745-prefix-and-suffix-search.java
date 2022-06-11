import java.util.*;

/*
 * 0745-prefix-and-suffix-search.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/06/11
 */
public class WordFilter {

    private Trie trieRoot;

    public WordFilter(String[] words) {
        trieRoot = new Trie('\0');
        for (int i = 0; i < words.length; i++) {
            String word = "{" + words[i];
            trieRoot.add(word, i);
            for (int j = words[i].length() - 1; j >= 0; j--) {
                word = words[i].charAt(j) + word;
                trieRoot.add(word, i);
            }
        }
    }

    public int f(String prefix, String suffix) {
        return trieRoot.find(suffix + "{" + prefix);
    }

    public static void main(String[] args) {
        WordFilter wf = new WordFilter(new String[] {"apple"});
        // [0]
        System.out.println(wf.f("a", "e"));
    }
}

class Trie {
    char val;
    Trie[] nexts;
    int maxWordIdx;

    public Trie(char ch) {
        this.val = ch;
        this.nexts = new Trie[27];
        this.maxWordIdx = -1;
    }

    public void add(String word, int i) {
        Trie node = this;
        for (int j = 0; j < word.length(); j++) {
            char ch = word.charAt(j);
            int chIdx = ch - 'a';
            if (node.nexts[chIdx] == null) {
                node.nexts[chIdx] = new Trie(ch);
            }
            node = node.nexts[chIdx];
        }
        node.maxWordIdx = Math.max(node.maxWordIdx, i);
    }

    public int find(String prefix) {
        Trie node = this;
        for (int j = 0; j < prefix.length(); j++) {
            char ch = prefix.charAt(j);
            int chIdx = ch - 'a';
            node = node.nexts[chIdx];
            if (node == null) {
                break;
            }
        }
        if (node == null) {
            return -1;
        }
        LinkedList<Trie> queue = new LinkedList<>();
        queue.add(node);

        int max = -1;
        while (!queue.isEmpty()) {
            node = queue.poll();
            max = Math.max(node.maxWordIdx, max);
            
            for (Trie next : node.nexts) {
                if (next != null) {
                    queue.add(next);
                }
            }
        }
        return max;
    }
}
