import java.util.LinkedList;
import java.util.stream.Collectors;

/*
 * 0394-decode-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/19
 */
public class Solution {
    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ']') {
                StringBuilder letterBuilder = new StringBuilder();
                while (!stack.isEmpty() && !"[".equals(stack.peekLast())) {
                    letterBuilder.insert(0, stack.removeLast());
                }
                // pop "["
                stack.removeLast();
                String encStr = letterBuilder.toString();

                StringBuilder numBuilder = new StringBuilder();
                while (!stack.isEmpty() && stack.peekLast().charAt(0) >= '0' && stack.peekLast().charAt(0) <= '9') {
                    numBuilder.insert(0, stack.removeLast());
                }
                int k = Integer.parseInt(numBuilder.toString());

                // add another k-1 encoded_string
                while (k > 1) {
                    letterBuilder.append(encStr);
                    k--;
                }

                // finally, add k[encStr] to stack
                stack.addLast(letterBuilder.toString());
            } else {
                stack.addLast(ch + "");
            }
        }
        return stack.stream().collect(Collectors.joining());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "aaabcbc"
        System.out.println(s.decodeString("3[a]2[bc]"));
        // "accaccacc"
        System.out.println(s.decodeString("3[a2[c]]"));
        // "abcabccdcdcdef"
        System.out.println(s.decodeString("2[abc]3[cd]ef"));
        // "abccdcdcdxyz"
        System.out.println(s.decodeString("abc3[cd]xyz"));
    }
}