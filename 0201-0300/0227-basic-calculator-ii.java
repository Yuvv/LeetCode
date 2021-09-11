import java.util.*;

/*
 * 0227-basic-calculator-ii.java
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
            } else if (c == '*' || c == '/') {
                calcAndPush(stack, num, false);
                num = "0";
                stack.push("" + c);
            } else if (c == '+' || c == '-') {
                calcAndPush(stack, num, false);
                num = "0";
                stack.push("" + c);
            } else {
                num += c;
            }
        }
        calcAndPush(stack, num, false);
        int a = 0;
        stack.addLast("+");
        while (!stack.isEmpty()) {
            String op = stack.pollLast();
            int b = Integer.parseInt(stack.pollLast());
            if ("+".equals(op)) {
                a += b;
            } else {
                a -= b;
            }
        }

        return a;
    }

    public void calcAndPush(LinkedList<String> stack, String b, boolean isAddOrMinusOk) {
        String topStr = stack.peek();
        if ("*".equals(topStr) || "/".equals(topStr)) {
            String op = stack.pop();
            String a = stack.pop();
            if ("*".equals(op)) {
                stack.push(Objects.toString(Integer.parseInt(a) * Integer.parseInt(b)));
            } else {
                stack.push(Objects.toString(Integer.parseInt(a) / Integer.parseInt(b)));
            }
        } else if (isAddOrMinusOk && ("+".equals(topStr) || "-".equals(topStr))) {
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
         // 4067
        System.out.println(s.calculate("282-1*2*13-30-2*2*2/2-95/5*2+55+804+3024"));
        // -5659
        System.out.println(s.calculate("13+2*2/4*11-21*3*90-123/8+2"));
        // -539
        System.out.println(s.calculate("13+2*2/4-2*3*90-123/8+2"));
        // -191
        System.out.println(s.calculate("3+2*2/4-2*90-123/8"));
        // 4
        System.out.println(s.calculate("3+2*2/3"));
        // 7
        System.out.println(s.calculate("3+2*2"));
        // 1
        System.out.println(s.calculate(" 3/2 "));
        // 5
        System.out.println(s.calculate(" 3+5 / 2 "));
        // 7
        System.out.println(s.calculate("3+2*2"));
    }
}