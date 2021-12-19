/*
 * 1544-make-the-string-great.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/19
 */
public class Solution {
    public String makeGood(String s) {
        StringBuilder res = new StringBuilder();
        int i;
        for (i = 0; i < s.length() - 1; i++) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i + 1);
            if (Math.abs(ch1 - ch2) == 32) {
                i++;
            } else if (res.length() > 0 && Math.abs(ch1 - res.charAt(res.length() - 1)) == 32) {
                res.deleteCharAt(res.length() - 1);
            } else {
                res.append(ch1);
            }
        }
        if (i < s.length()) {
            if (res.length() > 0 && Math.abs(s.charAt(i) - res.charAt(res.length() - 1)) == 32) {
                res.deleteCharAt(res.length() - 1);
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "leetcode"
        System.out.println(s.makeGood("leEeetCode"));
        // "abBAcC"
        System.out.println(s.makeGood(""));
        // "s"
        System.out.println(s.makeGood("s"));
    }
}