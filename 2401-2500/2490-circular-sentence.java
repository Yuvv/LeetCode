/**
 * 2490-circular-sentence.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/11/02
 */
public class Solution {
    public boolean isCircularSentence(String sentence) {
        if (sentence.charAt(0) != sentence.charAt(sentence.length()-1)) {
            return false;
        }
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch == ' ') {
                if (sentence.charAt(i-1) != sentence.charAt(i+1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isCircularSentence("leetcode exercises sound delightful"));
        // true
        System.out.println(s.isCircularSentence("eetcode"));
        // false
        System.out.println(s.isCircularSentence("Leetcode is cool"));
    }
}
