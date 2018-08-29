class Solution {
    /**
     * 找出第 n 个数字
     * https://leetcode.com/problems/nth-digit/description/
     *
     * 1-9, 9*1
     * 10-99, 90*2
     * 100-999, 900*3
     * ...
     *
     * 算出在哪一个区间，然后算出应该是哪个数字( x / rount)
     * 然后算出在数字的哪个位置(x % round)
     */
    public int findNthDigit(int n) {
        long base = 9;
        long round = 1;
        long count = 0;
        long cumValue = 0;

        while (base * round < n) {
            count += base * round;
            cumValue += base;
            base *= 10;
            round += 1;
        }

        long value = (n - count - 1) / round + cumValue + 1;
        long pos = (n - count - 1) % round;

        return ("" + value).charAt((int)pos) - '0';
    }
}