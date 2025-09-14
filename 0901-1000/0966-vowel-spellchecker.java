import java.util.*;
/**
 * 0966-vowel-spellchecker.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/09/14
 */
public class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> originSet = new HashSet<>();
        Map<String, String> lowerMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();
        for (int i = 0; i < wordlist.length; i++) {
            String word = wordlist[i];
            originSet.add(word);
            lowerMap.putIfAbsent(word.toLowerCase(), word);
            vowelMap.putIfAbsent(replaceVowel(word.toLowerCase()), word);
        }
        String[] resList = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            // resList[i] = query(queries[i], originSet, lowerMap);
            String q = queries[i];
            if (originSet.contains(q)) {
                resList[i] = q;
            } else {
                q = q.toLowerCase();
                if (lowerMap.containsKey(q)) {
                    resList[i] = lowerMap.get(q);
                } else {
                    q = replaceVowel(q);
                    if (vowelMap.containsKey(q)) {
                        resList[i] = vowelMap.get(q);
                    } else {
                        resList[i] = "";
                    }
                }
            }
        }
        return resList;
    }
    private String replaceVowel(String q) {
        char[] qs = q.toCharArray();
        for (int i = 0; i < q.length(); i++) {
            if (qs[i] != 'a' && qs[i] != 'e' && qs[i] != 'i' && qs[i] != 'o' && qs[i] != 'u') {
                continue;
            }
            qs[i] = 'a';
        }
        return new String(qs);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
        System.out.println(s.spellchecker(
            new String[]{"KiTe","kite","hare","Hare"},
            new String[]{"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"}
        ));
        // ["yellow"]
        System.out.println(s.spellchecker(
            new String[]{"yellow"},
            new String[]{"YellOw"}
        ));
    }
}