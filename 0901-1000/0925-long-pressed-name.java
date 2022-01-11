/*
 * 0925-long-pressed-name.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/11
 */
public class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if (typed.length() < name.length()) {
            return false;
        }
        int i = 0, j = 0;
        char last = name.charAt(0);
        while (i < name.length() && j < typed.length()) {
            char a = name.charAt(i);
            char b = typed.charAt(j);
            if (a != b) {
                while (j < typed.length() && b == last) {
                    b = typed.charAt(j);
                    j++;
                }
                if (b != a) {
                    return false;
                }
                // j already moved to next, so we need subscribe 1
                j--;
            }
            i++;
            j++;
            last = a;
        }
        if (i < name.length()) {
            return false;
        }
        while (j < typed.length()) {
            if (typed.charAt(j) != last) {
                return false;
            }
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isLongPressedName("alex", "aaleex"));
        // false
        System.out.println(s.isLongPressedName("saeed", "ssaaedd"));
        // true
        System.out.println(s.isLongPressedName("babab", "bbaaabbaab"));
        // false
        System.out.println(s.isLongPressedName("babab", "bbaaabbaaba"));
    }
}