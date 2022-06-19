import java.util.*;

/*
 * 1268-search-suggestions-system.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/06/19
 */
public class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie('\0');
        for (String word : products) {
            root.addWord(word);
        }
        return root.find(searchWord);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [
        //    ["mobile","moneypot","monitor"],
        //    ["mobile","moneypot","monitor"],
        //    ["mouse","mousepad"],
        //    ["mouse","mousepad"],
        //    ["mouse","mousepad"]
        // ]
        System.out.println(s.suggestedProducts(
            new String[] {"mobile","mouse","moneypot","monitor","mousepad"},
            "mouse"
        ));
    }
}

class Trie {
    char ch;
    Map<Character, Trie> nextMap;
    TreeSet<String> currentWords;

    public Trie(char ch) {
        this.ch = ch;
        this.nextMap = new HashMap<>();
        this.currentWords = new TreeSet<>();
    }

    public void addWord(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            node = node.nextMap.computeIfAbsent(ch, Trie::new);
            node.currentWords.add(word);
        }
    }

    public List<List<String>> find(String word) {
        List<List<String>> resList = new ArrayList<>();

        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node != null) {
                node = node.nextMap.get(ch);
            }
            if (node == null) {
                resList.add(new ArrayList<>(0));
            } else {
                List<String> list = new ArrayList<>(Math.min(3, node.currentWords.size()));
                Iterator<String> it = node.currentWords.iterator();
                int cnt = 0;
                while (it.hasNext() && cnt < 3) {
                    list.add(it.next());
                    cnt++;
                }
                resList.add(list);
            }
        }

        return resList;
    }
}