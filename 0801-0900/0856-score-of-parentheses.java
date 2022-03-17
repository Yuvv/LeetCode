import java.util.*;

/*
 * 0856-score-of-parentheses.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/17
 */
public class Solution {
    public int scoreOfParentheses(String s) {
        LinkedList<Node> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++ ) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(new Node(ch));
            } else {
                Node top = stack.pop();
                if (top.isChar) {
                    Node node = new Node(1);
                    while (!stack.isEmpty() && !stack.peek().isChar) {
                        node.val += stack.pop().val;
                    }
                    stack.push(node);
                } else {
                    Node node = top;
                    node.val *= 2;
                    stack.pop(); // pop last '('
                    while (!stack.isEmpty() && !stack.peek().isChar) {
                        node.val += stack.pop().val;
                    }
                    stack.push(node);
                }
            }
            System.out.println(stack);
        }
        return stack.pop().val;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 15
        System.out.println(s.scoreOfParentheses("(()((())()))()"));
        // 1
        System.out.println(s.scoreOfParentheses("()"));
        // 2
        System.out.println(s.scoreOfParentheses("(())"));
        // 2
        System.out.println(s.scoreOfParentheses("()()"));
    }
}

class Node {
    int val;
    char ch;
    boolean isChar;

    public Node(int val) {
        this.val = val;
        this.isChar = false;
    }

    public Node(char ch) {
        this.ch = ch;
        this.isChar = true;
    }

    @Override
    public String toString() {
        String center = "" + val;
        if (isChar) {
            center = "\'" + ch + "\'";
        }
        return "Node(" + center + ")";
    }
}
