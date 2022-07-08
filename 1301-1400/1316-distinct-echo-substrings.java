import java.util.Set;
import java.util.HashSet;

/*
 * 1316-distinct-echo-substrings.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/09
 */
public class Solution {
    private boolean isOk(String text, int from, int len) {
        for (int i = 0; i < len; i++) {
            if (text.charAt(from + i) != text.charAt(from + len + i)) {
                return false;
            }
        }
        return true;
    }

    // brute force
    public int distinctEchoSubstrings(String text) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < text.length(); i++) {
            for (int j = 1; j <= (text.length() - i) / 2; j++) {
                String candidate = text.substring(i, i + j);
                if (!set.contains(candidate) && isOk(text, i, j)) {
                    set.add(candidate);
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.distinctEchoSubstrings("abcabcabc"));
        // 2
        System.out.println(s.distinctEchoSubstrings("leetcodeleetcode"));
    }
}