/*
 * 2000-reverse-prefix-of-word.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/16
 */
public class Solution {
    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        if (idx < 0) {
            return word;
        }
        idx++;
        return new StringBuilder(word.substring(0, idx))
                .reverse()
                .append(word.substring(idx))
                .toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // dcbaefd
        System.out.println(s.reversePrefix("abcdefd", 'd'));
        // zxyxxe
        System.out.println(s.reversePrefix("xyxzxe", 'z'));
        // abcd
        System.out.println(s.reversePrefix("abcd", 'z'));

    }
}