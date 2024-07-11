import java.util.*;
import java.util.stream.Collectors;
/**
 * 1190-reverse-substrings-between-each-pair-of-parentheses.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/11
 */
public class Solution {
    public String reverseParentheses(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                LinkedList<Character> queue = new LinkedList<>();
                while (!stack.isEmpty() && stack.getLast() != '(') {
                    queue.addLast(stack.removeLast());
                }
                stack.removeLast(); // pop '('
                while (!queue.isEmpty()) {
                    stack.addLast(queue.removeFirst());
                }
            } else {
                stack.addLast(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        stack.forEach(sb::append);
        return sb.toString();

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "dcba"
        System.out.println(s.reverseParentheses("(abcd)"));
        // "iloveu"
        System.out.println(s.reverseParentheses("(u(love)i)"));
        // "leetcode"
        System.out.println(s.reverseParentheses("(ed(et(oc))el)"));
    }
}
