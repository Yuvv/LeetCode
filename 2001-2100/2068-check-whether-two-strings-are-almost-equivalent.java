import java.util.Map;
import java.util.HashMap;

/*
 * 2068-check-whether-two-strings-are-almost-equivalent.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/16
 */
public class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            char ch = word1.charAt(i);
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> count2Map = new HashMap<>();
        for (int i = 0; i < word2.length(); i++) {
            char ch = word2.charAt(i);
            count2Map.put(ch, count2Map.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (Math.abs(entry.getValue() - count2Map.getOrDefault(entry.getKey(), 0)) > 3) {
                return false;
            }
            count2Map.remove(entry.getKey());
        }
        for (Integer cnt : count2Map.values()) {
            if (cnt > 3) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // false
        System.out.println(s.checkAlmostEquivalent("aaaa", "bccb"));
        // true
        System.out.println(s.checkAlmostEquivalent("abcdeef", "abaaacc"));
        // true
        System.out.println(s.checkAlmostEquivalent("aaaa", "aaaa"));
        // false
        System.out.println(s.checkAlmostEquivalent(
            "bddhdfcdihfehbehfeiccehhchbibiggifcbgieedgfhggebcbeeddfdfiehcigdfcccdhgchbbfheddbdbiifeeiieg",
            "cdecdhhfgdieiifhhifffcgddeehgbciceggedbdggbigiieidgcceccgfhiecdefdhighbfdcdbgcfddeebbgibcihe"
        ));

    }
}