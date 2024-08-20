import java.util.*;
/**
 * 1003-check-if-word-is-valid-after-substitutions.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/20
 */
public class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == 'c') {
                if (stack.size() < 2) {
                    return false;
                }
                if (stack.peek() != 'b') {
                    return false;
                }
                stack.pop();
                if (stack.peek() != 'a') {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
            i++;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isValid("aabcbc"));
        // true
        System.out.println(s.isValid("abcabcababcc"));
        // false
        System.out.println(s.isValid("abccba"));
    }
}
