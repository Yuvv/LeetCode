import java.util.LinkedList;

/*
 * 0032-longest-valid-parentheses.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2019/07/06
 */
public class Solution {
    /**
     * 求最长的合法的括号对的长度
     *
     * @param s 待匹配字符串
     * @return 最长长度
     */
    public int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        int pos = 0;
        int curLength = 0, maxLength = 0;
        while (pos < s.length() && s.charAt(pos) == ')') {
            pos++;
        }
        while (pos < s.length()) {
            if (s.charAt(pos) == '(') {
                stack.push(0);
            } else {
                Integer val = stack.pop();
                if (val.compareTo(0) == 0) {
                    // 匹配到左括号直接 push 长度 2
                    stack.push(2);
                } else if (val.compareTo(0) < 0) {
                    // 匹配到右括号则 push pop 出来的右括号和当前右括号
                    stack.push(val);
                    stack.push(-2);
                } else {
                    // 匹配到中间有括号对的则求中间的长度和
                    int midSum = val;
                    while (!stack.isEmpty()) {
                        val = stack.pop();
                        if (val.compareTo(0) > 0) {
                            midSum += val;
                        } else {
                            break;
                        }
                    }
                    if (val.compareTo(0) == 0) {
                        // 匹配到左括号则中间长度和 +2 之后 push 回去
                        midSum += 2;
                        stack.push(midSum);
                    } else {
                        // 这种时候肯定可能是匹配到右括号或者栈为空了
                        if (!stack.isEmpty()) {
                            // 栈不为空则是匹配到右括号 break 了，此时需要将右括号再 push 回去
                            stack.push(val);
                        }
                        stack.push(midSum);
                        stack.push(-2);
                    }

                }
            }
            pos++;
        }

        while (!stack.isEmpty()) {
            Integer val = stack.pop();
            if (val.compareTo(0) > 0) {
                curLength += val;
            } else {
                curLength = 0;
            }
            if (curLength > maxLength) {
                maxLength = curLength;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2 expected
        System.out.println(s.longestValidParentheses("(()"));
        // 4 expected
        System.out.println(s.longestValidParentheses(")()())"));
        // 2 expected
        System.out.println(s.longestValidParentheses("()(()"));
        // 2 expected
        System.out.println(s.longestValidParentheses("(()(((()"));
    }
}