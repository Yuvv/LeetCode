/**
 * 2434-using-a-robot-to-print-the-lexicographically-smallest-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/06/14
 */
public class Solution {
    public String robotWithString(String s) {
        StringBuilder res = new StringBuilder();
        char[] postMin = new char[s.length()];
        postMin[s.length() - 1] = s.charAt(s.length() - 1);
        for (int i = s.length() - 2; i >= 0; i--) {
            postMin[i] = (char) Math.min(s.charAt(i), postMin[i + 1]);
        }
        char[] stack = new char[s.length()];
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (top >= 0 && stack[top] <= postMin[i]) {
                res.append(stack[top--]);
            }
            stack[++top] = c;
        }
        while (top >= 0) {
            res.append(stack[top--]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "azz"
        System.out.println(s.robotWithString("zza"));
        // "abc"
        System.out.println(s.robotWithString("bac"));
        // "addb"
        System.out.println(s.robotWithString("bdda"));
    }
}