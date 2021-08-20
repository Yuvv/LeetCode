import java.util.*;

/*
 * 1910-remove-all-occurrences-of-a-substring.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/20
 */
public class Solution {
    public String removeOccurrences(String s, String part) {
        int idx = -1;
        while (s.length() >= part.length() && (idx = s.indexOf(part)) >= 0) {
            s = s.replaceFirst(part, "");
        }
        return s;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "dab"
        System.out.println(s.removeOccurrences("daabcbaabcbc", "abc"));
        // "ab"
        System.out.println(s.removeOccurrences("axxxxyyyyb", "xy"));
    }
}