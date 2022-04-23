import java.util.*;

/*
 * 1684-count-the-number-of-consistent-strings.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/24
 */
public class Solution {
    private Set<Character> buildSet(String s) {
        Set<Character> set = new HashSet<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set;
    }

    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedSet = buildSet(allowed);
        int count = 0;
        for (String s : words) {
            Set<Character> ss = buildSet(s);
            if (allowedSet.containsAll(ss)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.countConsistentStrings(
            "ab",
            new String[] {"ad", "bd", "aaab", "baa", "badab"}
        ));
        // 7
        System.out.println(s.countConsistentStrings(
            "abc",
            new String[] {"a","b","c","ab","ac","bc","abc"}
        ));
    }
}