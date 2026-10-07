import java.util.*;

/**
 * 301-Remove-Invalid-Parentheses.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2026/10/7
 */
public class Solution {
    private int getInvalidCnt(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    cnt++;
                }
            }
        }

        return cnt + stack.size();
    }

    private void dfs(Set<String> resList, LinkedList<Character> stack, StringBuilder sb, String s, int idx, int invalidCnt) {
        if (idx >= s.length()) {
            if (invalidCnt == 0 && stack.isEmpty()) {
                resList.add(sb.toString());
            }
            return;
        }
        if (invalidCnt < 0) {
            // invalid
            return;
        }

        char ch = s.charAt(idx);
        if (ch == '(') {
            // 1. use it
            stack.push(ch);
            sb.append(ch);
            dfs(resList, stack, sb, s, idx + 1, invalidCnt);
            stack.pop();
            sb.deleteCharAt(sb.length() - 1);
            // 2. remote it
            if (invalidCnt > 0) {
                dfs(resList, stack, sb, s, idx + 1, invalidCnt - 1);
            }
        } else if (ch == ')') {
            if (!stack.isEmpty() && stack.peek() == '(') { // is valid
                // 1. use it
                stack.pop();
                sb.append(ch);
                dfs(resList, stack, sb, s, idx + 1, invalidCnt);
                stack.push('(');
                sb.deleteCharAt(sb.length() - 1);
                // 2. remove it
                if (invalidCnt > 0) {
                    dfs(resList, stack, sb, s, idx + 1, invalidCnt - 1);
                }
            } else { // is invalid
                // remote it
                if (invalidCnt > 0) {
                    dfs(resList, stack, sb, s, idx + 1, invalidCnt - 1);
                }
            }
        } else {
            sb.append(ch);
            dfs(resList, stack, sb, s, idx + 1, invalidCnt);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        int invalidCnt = getInvalidCnt(s);
        Set<String> resSet = new HashSet<>();
        dfs(resSet, new LinkedList<>(), new StringBuilder(), s, 0, invalidCnt);
        return new ArrayList<>(resSet);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ["(())()","()()()"]
        System.out.println(s.removeInvalidParentheses("()())()"));
        // ["(a())()","(a)()()"]
        System.out.println(s.removeInvalidParentheses("(a)())()"));
        // [""]
        System.out.println(s.removeInvalidParentheses(")("));
        //
        System.out.println(s.removeInvalidParentheses("((d()d(()))(a((((((b(()e("));
    }
}
