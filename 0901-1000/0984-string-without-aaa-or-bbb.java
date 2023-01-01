/*
 * 0984-string-without-aaa-or-bbb.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/01/01
 */
public class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        while (a > 0 || b > 0) {
            if (a - b >= 2) {
                sb.append("aa");
                a -= 2;
                if (b > 0) {
                    sb.append("b");
                    b -= 1;
                }
            } else if (b - a >= 2) {
                sb.append("bb");
                b -= 2;
                if (a > 0) {
                    sb.append("a");
                    a -= 1;
                }
            } else if (a - b >=1) {
                sb.append("a");
                a -= 1;
                if (b > 0) {
                    sb.append("b");
                    b -= 1;
                }
            } else if (b - a >= 1) {
                sb.append("b");
                b -= 1;
                if (a > 0) {
                    sb.append("a");
                    a -= 1;
                }
            } else {
                sb.append("ab");
                a -= 1;
                b -= 1;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "abb"
        System.out.println(s.strWithout3a3b(1, 2));
        // "bbab"
        System.out.println(s.strWithout3a3b(1, 3));
        // "aabaa"
        System.out.println(s.strWithout3a3b(4, 1));
    }
}