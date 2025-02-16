/**
 * 3403-find-the-lexicographically-largest-string-from-the-box-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/02/16
 */
public class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        String candidate = "";
        for (int i = 0; i < word.length(); i++) {
            for (int j = Math.min(word.length()-i, word.length()-numFriends+1); j >= 1; j--) {
                String ss = word.substring(i, i+j);
                if (ss.compareTo(candidate) > 0) {
                    candidate = ss;
                } else {
                    break;
                }
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "dbc"
        System.out.println(s.answerString("dbca", 2));
        // "g"
        System.out.println(s.answerString("gggg", 4));
    }
}
