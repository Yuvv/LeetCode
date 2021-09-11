import java.util.*;

/*
 * 0224-basic-calculator.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/11
 */
public class Solution {
    public int calculate(String s) {
        LinkedList<String> stack = new LinkedList<>();

        // calc
        String num = "0";
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == ' ') {
                continue;
            } else if (c == '(') {
                stack.push("" + c);
            } else if (c == ')') {
                calcAndPush(stack, num);
                num = stack.pop();
                stack.pop(); // pop "("
            } else if (c == '+' || c == '-') {
                calcAndPush(stack, num);
                num = "0";
                stack.push("" + c);
            } else {
                num += c;
            }
        }
        if (!"0".equals(num)) {
            calcAndPush(stack, num);
        }

        return Integer.parseInt(stack.pop());
    }

    public void calcAndPush(LinkedList<String> stack, String b) {
        if ("+".equals(stack.peek()) || "-".equals(stack.peek())) {
            String op = stack.pop();
            String a = stack.pop();
            if ("+".equals(op)) {
                stack.push(Objects.toString(Integer.parseInt(a) + Integer.parseInt(b)));
            } else {
                stack.push(Objects.toString(Integer.parseInt(a) - Integer.parseInt(b)));
            }
        } else {
            stack.push(b);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.calculate("1 + 1"));
        // 3
        System.out.println(s.calculate(" 2-1 + 2 "));
        // 23
        System.out.println(s.calculate("(1+(4+5+2)-3)+(6+8)"));
        // 1
        System.out.println(s.calculate("(1+(4+5+2)-3)+(-8)"));
        // -12
        System.out.println(s.calculate("- (3 + (4 + 5))"));
    }
}