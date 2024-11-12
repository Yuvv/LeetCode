import java.util.*;

/**
 * 3324-find-the-sequence-of-strings-appeared-on-the-screen.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/10/30
 */
public class Solution {
    public List<String> stringSequence(String target) {
        List<String> resList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < target.length()) {
            if (sb.length() <= idx) {
                sb.append('a');
            } else if (sb.charAt(idx) != target.charAt(idx)) {
                sb.setCharAt(idx, (char)(sb.charAt(idx)+1));
            } else {
                idx++;
                continue;
            }
            resList.add(sb.toString());
        }
        return resList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ["a","aa","ab","aba","abb","abc"]
        System.out.println(s.stringSequence("abc"));
        // ["a","b","c","d","e","f","g","h","ha","hb","hc","hd","he"]
        System.out.println(s.stringSequence("he"));
    }
}

