class Solution {
    public int divide(int dividend, int divisor) {
        // 垃圾题目有什么意义。。。
        if (dividend == -2147483648 && divisor == -1) {
            dividend += 1;
        }
        return dividend / divisor;
    }
}