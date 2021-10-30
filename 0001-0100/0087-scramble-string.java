import java.util.*;

/*
 * 0087-scramble-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/10/27
 */
public class Solution {

    private Map<String, Boolean> cacheMap = null;

    public boolean isScramble(String s1, String s2) {
        if (cacheMap == null) {
            cacheMap = new HashMap<>();
        }
        if (s1.equals(s2)) {
            return true;
        }
        String key = s1 + "," + s2;
        if (cacheMap.containsKey(key)) {
            return cacheMap.get(key);
        }

        for (int i = 1; i < s1.length(); i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);

            boolean res = isScramble(s11, s21) && isScramble(s12, s22);
            if (res) {
                cacheMap.put(key, res);
                return res;
            }
            s21 = s2.substring(0, s2.length() - i);
            s22 = s2.substring(s2.length() - i);
            res = isScramble(s11, s22) && isScramble(s12, s21);
            if (res) {
                cacheMap.put(key, res);
                return res;
            }
        }
        cacheMap.put(key, false);
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isScramble("great", "rgeat"));
        // false
        System.out.println(s.isScramble("abcde", "caebd"));
        // true
        System.out.println(s.isScramble("a", "a"));
        // true
        System.out.println(s.isScramble("kyzgymljxxcledpougfnsyodswfego", "osnfgdpougewfyodszygkxymljxecl"));
        // false
        System.out.println(s.isScramble("oyzgymljxxcledpougfnsyodswfegk", "osnfgdpougewfyodszygkxymljxecl"));
    }
}