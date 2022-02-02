import java.util.*;

/*
 * 0567-permutation-in-string.java
 *
 * @author yuweiwei7 <yuweiwei3@jd.com>
 * @date 2022/02/02
 */
public class Solution {
    public boolean checkInclusion(String p, String s) {
        if (p.length() > s.length()) {
            return false;
        }
        Map<Character, Integer> pm = new HashMap<>();
        Map<Character, Integer> sm = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            pm.put(ch, pm.getOrDefault(ch, 0) + 1);
            char chm = s.charAt(i);
            sm.put(chm, sm.getOrDefault(chm, 0) + 1);
        }
        // check at each index
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (isOk(sm, pm)) {
                return true;
            }
            if (i + p.length() < s.length()) {
                char a = s.charAt(i);
                char b = s.charAt(i + p.length());
                if (a != b) {
                    sm.put(a, sm.getOrDefault(a, 0) - 1);
                    if (sm.get(a) == 0) {
                        sm.remove(a);
                    }
                    sm.put(b, sm.getOrDefault(b, 0) + 1);
                }
            }
        }

        return false;
    }

    public boolean isOk(Map<Character, Integer> sm, Map<Character, Integer> pm) {
        if (sm.size() != pm.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : pm.entrySet()) {
            if (!sm.containsKey(entry.getKey())) {
                return false;
            }
            if (!sm.get(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.checkInclusion("ab", "eidbaooo"));
        // false
        System.out.println(s.checkInclusion("ab", "eidboaoo"));

    }
}