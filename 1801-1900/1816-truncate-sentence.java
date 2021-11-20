/*
 * 1816-truncate-sentence.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/20
 */
public class Solution {
    public String truncateSentence(String s, int k) {
        int i;
        for (i = 0; k > 0 && i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                k--;
            }
        }
        if (k > 0) {
            return s;
        }
        return s.substring(0, i - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "Hello how are you"
        System.out.println(s.truncateSentence("Hello how are you Contestant", 4));
        // "chopper is not a tanuki"
        System.out.println(s.truncateSentence("chooper is not a tanuki", 5));
    }
}