/**
 * 2864-maximum-odd-binary-number.java
 *
 * @date 2024/3/9
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] sch = s.toCharArray();
        int toSetPos = 0;
        for (int i = 0; i < sch.length; i++) {
            if (sch[i] == '1') {
                sch[i] = '0';
                sch[toSetPos] = '1';
                toSetPos++;
            }
        }
        // s contains at least one '1'
        sch[toSetPos-1] = '0';
        sch[sch.length-1] = '1';

        return new String(sch);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "001"
        System.out.println(s.maximumOddBinaryNumber("010"));
        // "1001"
        System.out.println(s.maximumOddBinaryNumber("0101"));
    }
}
