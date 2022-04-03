import java.util.*;

/*
 * 0316-remove-duplicate-letters.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/18
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIdx = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            lastIdx[ch - 'a'] = i;
        }
        LinkedList<Character> stack = new LinkedList<>();
        boolean[] seen = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            if (seen[idx]) {
                continue;
            }
            while (!stack.isEmpty() && ch < stack.peek() && lastIdx[stack.peek() - 'a'] > i) {
                seen[stack.pop() - 'a'] = false;
            }
            stack.push(ch);
            seen[idx] = true;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Character> it = stack.descendingIterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "abc"
        System.out.println(s.removeDuplicateLetters("bcabc"));
        // "acdb"
        System.out.println(s.removeDuplicateLetters("cbacdcbc"));
    }
}