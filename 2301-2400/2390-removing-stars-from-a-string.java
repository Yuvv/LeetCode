import java.util.LinkedList;
/**
 * 2390-removing-stars-from-a-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/02/23
 */
public class Solution {
    public String removeStars(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "lecoe"
        System.out.println(s.removeStars("leet**cod*e"));
        // ""
        System.out.println(s.removeStars("erase*****"));
    }
}
