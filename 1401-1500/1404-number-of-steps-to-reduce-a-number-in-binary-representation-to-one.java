/**
 * 1404-number-of-steps-to-reduce-a-number-in-binary-representation-to-one.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/05/29
 */
public class Solution {
    public int numSteps(String s) {
        int i = s.length() - 1;
        int carry = 0;
        int nStep = 0;
        while (i > 0) {
            int ch = s.charAt(i) - '0';
            ch += carry;
            if (ch == 2) { // even
                carry = 1;
                nStep++;
            } else if (ch == 1) { // odd
                carry = 1;
                nStep += 2;
            } else { // even
                carry = 0;
                nStep++;
            }
            i--;
        }
        // s[0] == '1'
        if (carry == 0) {
            return nStep;
        } else {
            return nStep + 1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.numSteps("1101"));
        // 1
        System.out.println(s.numSteps("10"));
        // 0
        System.out.println(s.numSteps("1"));
    }
}