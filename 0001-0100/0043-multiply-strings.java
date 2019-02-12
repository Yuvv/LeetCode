class Solution {
    /**
     * 实现字符串乘法
     * https://leetcode.com/problems/multiply-strings/
     */
    public String multiply(String num1, String num2) {
        String result = "0";
        if (result.equals(num1) || result.equals(num2)) {
            return result;
        }
        StringBuilder tempBuilder;
        int offset = 0;
        int tempResult;
        int n1, n2, carry = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            n1 = num1.charAt(i) - '0';
            tempBuilder = new StringBuilder();
            for (int j = num2.length() - 1; j >= 0; j--) {
                n2 = num2.charAt(j) - '0';
                tempResult = n1 * n2 + carry;
                carry = tempResult / 10;
                tempBuilder.insert(0, tempResult % 10);
            }
            if (carry > 0) {
                tempBuilder.insert(0, carry);
                carry = 0;
            }
            result = add(result, tempBuilder.toString(), offset);
            offset++;
        }
        return result;
    }

    private String add(String num1, String num2, int offset) {
        StringBuilder sb = new StringBuilder(num1.substring(num1.length() - offset, num1.length()));
        int carry = 0;
        int tmp;
        int n1, n2;
        int i = num1.length() - 1 - offset;
        int j = num2.length() - 1;

        while (i >= 0 && j >= 0) {
            n1 = num1.charAt(i--) - '0';
            n2 = num2.charAt(j--) - '0';
            tmp = n1 + n2 + carry;
            carry = tmp / 10;
            sb.insert(0, tmp % 10);
        }

        if (i < 0) {
            i = j;
            num1 = num2;
        }
        while (i >= 0) {
            n1 = num1.charAt(i--) - '0';
            tmp = n1 + carry;
            carry = tmp / 10;
            sb.insert(0, tmp % 10);
        }

        if (carry > 0) {
            sb.insert(0, carry);
        }

        return sb.toString();
    }
}