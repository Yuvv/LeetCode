import java.util.*;

/*
 * 2325-decode-the-message.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/09
 */
public class Solution {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < key.length() && cnt < 26; i++) {
            char ch = key.charAt(i);
            if (ch != ' ' && !map.containsKey(ch)) {
                map.put(ch, (char) ('a' + cnt));
                cnt++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch == ' ') {
                sb.append(ch);
            } else {
                sb.append(map.get(ch));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "this is a secret"
        System.out.println(s.decodeMessage(
            "the quick brown fox jumps over the lazy dog",
            "vkbs bs t suepuv"
            ));
    }
}
