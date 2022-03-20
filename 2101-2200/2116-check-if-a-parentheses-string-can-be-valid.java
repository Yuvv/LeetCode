import java.util.*;

/*
 * 2116-check-if-a-parentheses-string-can-be-valid.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/15
 */
public class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1) {
            return false;
        }
        // greedy deal with locked parentheses
        LinkedList<Integer> lockedLeftStack = new LinkedList<>();
        TreeMap<Integer, Character> unlockedTreeMap = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            char chs = s.charAt(i);
            char chl = locked.charAt(i);
            if (chl == '1') {
                if (chs == ')') {
                    // --> all locked ')' will be rmeoved
                    if (!lockedLeftStack.isEmpty()) {
                        lockedLeftStack.pop();
                    } else if (!unlockedTreeMap.isEmpty()) {
                        unlockedTreeMap.pollLastEntry();
                    } else {
                        return false;
                    }
                } else {
                    lockedLeftStack.push(i);
                }
            } else {
                // just push back and see it later
                unlockedTreeMap.put(i, chs);
            }
        }
        // now deal with locked '('
        while (!lockedLeftStack.isEmpty()) {
            Integer curIdx = lockedLeftStack.pop();
            Map.Entry<Integer, Character> entry = unlockedTreeMap.ceilingEntry(curIdx + 1);
            if (entry == null) {
                return false;
            }
            unlockedTreeMap.remove(entry.getKey());
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.canBeValid("())()))()(()(((())(()()))))((((()())(())", "1011101100010001001011000000110010100101"));
        // true
        System.out.println(s.canBeValid("))()))", "010100"));
        // true
        System.out.println(s.canBeValid("()()", "0000"));
        // false
        System.out.println(s.canBeValid(")", "0"));
        // true
        System.out.println(s.canBeValid("((()(()()))()((()()))))()((()(()", "10111100100101001110100010001001"));
    }
}
