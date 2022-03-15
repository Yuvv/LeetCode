import java.util.*;

/*
 * 1249-minimum-remove-to-make-valid-parentheses.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/15
 */
public class Solution {
    public String minRemoveToMakeValid(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        Set<Integer> toRemoveIdxList = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                if (stack.isEmpty() || s.charAt(stack.peek()) != '(') {
                    toRemoveIdxList.add(i);
                } else {
                    stack.pop();
                }
            } else if (ch == '(') {
                stack.push(i);
            }
        }
        toRemoveIdxList.addAll(stack);
        // build new string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (toRemoveIdxList.contains(i)) {
                continue;
            }
            char ch = s.charAt(i);
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "lee(t(c)o)de"
        System.out.println(s.minRemoveToMakeValid("lee(t(c)o)de)"));
        // "ab(c)d"
        System.out.println(s.minRemoveToMakeValid("a)b(c)d"));
        // ""
        System.out.println(s.minRemoveToMakeValid("))(("));
    }
}