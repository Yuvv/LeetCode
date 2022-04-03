import java.util.*;

/*
 * 1801-smallest-subsequence-of-distinct-characters.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/03
 */
public class Solution {
    public String smallestSubsequence(String s) {
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
        System.out.println(s.smallestSubsequence("bcabc"));
        // "acdb"
        System.out.println(s.smallestSubsequence("cbacdcbc"));
    }
}