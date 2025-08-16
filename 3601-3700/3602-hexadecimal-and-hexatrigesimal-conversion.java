/**
 * 3602-hexadecimal-and-hexatrigesimal-conversion.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/08/16
 */
public class Solution {
    static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public String concatHex36(int n) {
        StringBuilder sb = new StringBuilder();
        int a = n*n;
        while (a > 0) {
            sb.append(ALPHABET.charAt(a%16));
            a /= 16;
        }
        sb.reverse();
        int i = sb.length();
        int b = n*n*n;
        while (b > 0) {
            sb.append(ALPHABET.charAt(b%36));
            b /= 36;
        }
        int j = sb.length()-1;
        while (i < j) {
            char x = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, x);
            i++;
            j--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "A91P1"
        System.out.println(s.concatHex36(13));
        // "5101000"
        System.out.println(s.concatHex36(36));
    }
}