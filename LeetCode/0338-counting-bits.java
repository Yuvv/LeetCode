class Solution {
    /**
     * 求 0~n 中每个数的二进制数中1的个数
     * https://leetcode.com/problems/counting-bits/description/
     *
     * 使用二进制加法，逐步递推
     */
    public int[] countBits(int num) {
        int[] resultArr = new int[num + 1];
        resultArr[0] = 0;

        int value, carry;
        for (int i = 1; i <= num; i++) {
            value = i - 1;
            carry = value & 1;
            if (carry == 0) {
                resultArr[i] = resultArr[i - 1] + 1;
            } else {
                resultArr[i] = resultArr[i - 1] - 1;
                do {
                    value >>= 1;
                    carry &= value;
                    if (carry > 0) {
                        resultArr[i] -= 1;
                        carry = 1;
                    } else {
                        resultArr[i] += 1;
                        carry = 0;
                    }
                } while (value > 0 && carry > 0);
                if (carry > 0) {
                    resultArr[i] += 1;
                }
            }
        }
        return resultArr;
    }
}