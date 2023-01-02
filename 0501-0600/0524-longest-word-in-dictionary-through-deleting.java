import java.util.*;

/*
 * 0524-longest-word-in-dictionary-through-deleting.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/01/02
 */
public class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return b.length() - a.length();
        });
        for (String candidate : dictionary) {
            if (candidate.length() > s.length()) {
                continue;
            }
            int i = 0;
            int j = 0;
            while (i < candidate.length() && j < s.length()) {
                while (j < s.length() && s.charAt(j) != candidate.charAt(i)) {
                    j++;
                }
                i++;
                j++;
            }
            if (i >= candidate.length() && j <= s.length()) {
                return candidate;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "apple"
        System.out.println(s.findLongestWord(
            "abpcplea",
            Arrays.asList("ale", "apple", "monkey", "plea")
        ));
        // "a"
        System.out.println(s.findLongestWord(
            "abpcplea",
            Arrays.asList("a", "b", "c")
        ));
    }
}
