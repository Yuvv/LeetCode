class Solution {
    /**
     * 转换为-2进制数（先转换为2进制数，然后偶数位不变奇数位进1）
     * https://leetcode.com/problems/convert-to-base-2/
     *
     * @param N 待转换数
     * @return 结果
     */
    public String baseNeg2(int N) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(N));
        sb.reverse();

        int carry = 0, sum;
        int pos = 0;
        while (pos < sb.length()) {
            sum = carry + sb.charAt(pos) - '0';
            sb.setCharAt(pos, sum % 2 == 0 ? '0' : '1');
            carry = sum / 2;
            if (pos % 2 == 1 && sb.charAt(pos) == '1') {
                carry += 1;
            }
            pos++;
            if (pos >= sb.length() && carry > 0) {
                sb.append(Integer.toBinaryString(carry));
                carry = 0;
            }
        }

        return sb.reverse().toString();
    }
}