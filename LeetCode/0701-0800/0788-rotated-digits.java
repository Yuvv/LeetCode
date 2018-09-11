class Solution {
    /**
     * 翻转数字，反转之后合法且不和原来的数相等
     * https://leetcode.com/problems/rotated-digits/description/
     */
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (isValid(i)) {
                count++;
            }
        }
        return count;
    }

    boolean isValid(int n) {
        boolean hasCentrosymmetric = false;   // 中心对称 2569
        boolean hasAxisymmetric = false;      // 中心对称 018
        int remainder;
        while (n > 0) {
            remainder = n % 10;
            n /= 10;
            switch (remainder) {
                case 2:
                case 5:
                case 6:
                case 9:
                hasCentrosymmetric = true;
                break;

                case 0:
                case 1:
                case 8:
                hasAxisymmetric = true;
                break;

                default:
                return false;
            }
        }
        if (!hasCentrosymmetric) {
            return false;
        }
        return true;
    }

}