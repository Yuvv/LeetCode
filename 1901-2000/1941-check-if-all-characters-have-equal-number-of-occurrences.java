import java.util.Map;
import java.util.HashMap;

/*
 * 1941-check-if-all-characters-have-equal-number-of-occurrences.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/19
 */
public class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        return countMap.values().stream().distinct().count() == 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.areOccurrencesEqual("abacbc"));
        // false
        System.out.println(s.areOccurrencesEqual("aaabb"));
    }
}