import java.util.*;

/*
 * 0150-evaluate-reverse-polish-notation.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/18
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> numStack = new LinkedList<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                Integer b = numStack.pop();
                Integer a = numStack.pop();
                numStack.push(a + b);
            } else if ("-".equals(token)) {
                Integer b = numStack.pop();
                Integer a = numStack.pop();
                numStack.push(a - b);
            } else if ("*".equals(token)) {
                Integer b = numStack.pop();
                Integer a = numStack.pop();
                numStack.push(a * b);
            } else if ("/".equals(token)) {
                Integer b = numStack.pop();
                Integer a = numStack.pop();
                numStack.push(a / b);
            } else {
                numStack.push(Integer.parseInt(token));
            }
        }

        return numStack.pop();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 9
        System.out.println(s.evalRPN(new String[]{"2","1","+","3","*"}));
        // 6
        System.out.println(s.evalRPN(new String[]{"4","13","5","/","+"}));
        // 22
        System.out.println(s.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}