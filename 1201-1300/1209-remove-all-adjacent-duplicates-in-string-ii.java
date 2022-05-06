import java.util.*;

/*
 * 1209-remove-all-adjacent-duplicates-in-string-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/06
 */
public class Solution {
    public String removeDuplicates(String s, int k) {
        LinkedList<CharCounter> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(new CharCounter(ch));
            } else {
                if (stack.peek().ch == ch) {
                    stack.peek().increase();
                } else {
                    stack.push(new CharCounter(ch));
                }
            }
            if (stack.peek().count == k) {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            CharCounter cc = stack.pop();
            for (int i = 0; i < cc.count; i++) {
                sb.append(cc.ch);
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "abcd"
        System.out.println(s.removeDuplicates("abcd", 2));
        // "aa"
        System.out.println(s.removeDuplicates("deeedbbcccbdaa", 3));
        // "ps"
        System.out.println(s.removeDuplicates("pbbcggttciiippooaais", 2));
    }
}

class CharCounter {
    char ch;
    int count;

    public CharCounter(char ch) {
        this.ch = ch;
        this.count = 1;
    }

    public int increase() {
        count++;
        return count;
    }
}