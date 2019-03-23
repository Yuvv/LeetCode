class Solution {
    /**
     * 二进制数中1的距离的最大值
     * https://leetcode.com/problems/binary-gap/
     *
     * @param N 数
     * @return 距离最大值
     */
    public int binaryGap(int N) {
        int count = 0, max = 0;
        // power of 2
        if ((N & (N - 1))  == 0) {
            return 0;
        }
        // trailing right zeros
        while ((N & 1) == 0) {
            N >>= 1;
        }
        while (N > 0) {
            if ((N & 1) == 0) {
                count++;
            } else {
                count = 0;
            }
            if (count > max) {
                max = count;
            }
            N >>= 1;
        }
        return max + 1;
    }
}