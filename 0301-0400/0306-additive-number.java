/*
 * 0306-additive-number.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/24
 */
public class Solution {
    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i <= num.length() / 2; i++) {
            String as = num.substring(0, i);
            if (as.length() > 1 && as.charAt(0) == '0') {
                continue;
            }
            for (int j = i + 1; j <= (num.length() + i) / 2; j++) {
                String bs = num.substring(i, j);
                if (bs.length() > 1 && bs.charAt(0) == '0') {
                    continue;
                }
                if (isAdditiveNumber(num, j, Long.parseLong(as), Long.parseLong(bs))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAdditiveNumber(String num, int fromIdx, long a, long b) {
        if (fromIdx >= num.length()) {
            return false;
        }
        while (fromIdx < num.length()) {
            long c = a + b;
            String cs = "" + c;
            if (!num.startsWith(cs, fromIdx)) {
                return false;
            }
            a = b;
            b = c;
            fromIdx += cs.length();
        }
        return fromIdx == num.length();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isAdditiveNumber("112358"));
        // true
        System.out.println(s.isAdditiveNumber("199100199"));
        // false
        System.out.println(s.isAdditiveNumber("1991000199299498797"));
        // true
        System.out.println(s.isAdditiveNumber("198019823962"));
    }
}