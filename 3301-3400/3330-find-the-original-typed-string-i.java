/**
 * 3330-find-the-original-typed-string-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/07/05
 */
public class Solution {
    public int possibleStringCount(String word) {
        int cnt = 1;
        char prev = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == prev) {
                cnt++;
            }
            prev = c;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.possibleStringCount("abbcccc"));
        // 1
        System.out.println(s.possibleStringCount("abcd"));
        // 4
        System.out.println(s.possibleStringCount("aaaa"));
    }
}