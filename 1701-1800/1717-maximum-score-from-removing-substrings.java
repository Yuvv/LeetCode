import java.util.*;

/**
 * 1717-maximum-score-from-removing-substrings.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/12
 */
public class Solution {
    public int maximumGain(String s, int x, int y) {
        int gain = 0;
        char a = 'a', b = 'b';
        if (x < y) { // swap
            int tmp = x;
            x = y;
            y = tmp;
            char ch = a;
            a = b;
            b = ch;
        }
        LinkedList<Character> pStack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == b && !pStack.isEmpty() && pStack.peek() == a) {
                pStack.pop();
                gain += x;
            } else {
                pStack.push(ch);
            }
        }
        LinkedList<Character> sStack = new LinkedList<>();
        while (!pStack.isEmpty()) {
            char ch = pStack.pop();
            if (ch == b && !sStack.isEmpty() && sStack.peek() == a) {
                sStack.pop();
                gain += y;
            } else {
                sStack.push(ch);
            }
        }

        return gain;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 19
        System.out.println(s.maximumGain("cdbcbbaaabab", 4, 5));
        // 20
        System.out.println(s.maximumGain("aabbaaxybbaabb", 5, 4));
    }
}
