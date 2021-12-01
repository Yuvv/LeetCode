import java.util.Map;
import java.util.HashMap;

/*
 * 2085-count-common-words-with-one-occurrence.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/01
 */
public class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> cntMap = new HashMap<>(words1.length);
        for (String word : words1) {
            cntMap.put(word, cntMap.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            Integer cnt = cntMap.get(word);
            if (cnt == null || cnt > 1) {
                continue;
            }
            cntMap.put(word, cnt - 1);
        }

        return (int) cntMap.values().stream().filter(x -> x == 0).count();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.countWords(
            new String[] {"leetcode","is","amazing","as","is"},
            new String[] {"amazing","leetcode","is"}
        ));
        // 0
        System.out.println(s.countWords(
            new String[] {"b","bb","bbb"},
            new String[] {"a","aa","aaa"}
        ));
        // 1
        System.out.println(s.countWords(
            new String[] {"a","ab"},
            new String[] {"a","a","a","ab"}
        ));

    }
}