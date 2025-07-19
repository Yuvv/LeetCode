/**
 * 3136-valid-word.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/07/19
 */
public class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        boolean hasVowel = false;
        boolean hasConsonant = false;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isDigit(ch)) {
                continue;
            }
            if (!Character.isLetter(ch)) {
                return false;
            }
            if ("aeiouAEIOU".indexOf(ch) >= 0) {
                hasVowel = true;
            } else {
                hasConsonant = true;
            }
        }
        return hasVowel && hasConsonant;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isValid("234Adas"));
        // false
        System.out.println(s.isValid("b3"));
        // false
        System.out.println(s.isValid("a3$e"));
    }
}