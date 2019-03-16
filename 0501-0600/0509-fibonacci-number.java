class Solution {

    /**
     * 求斐波那契数列数
     * https://leetcode.com/problems/fibonacci-number/
     *
     * @param N 数
     * @return 第 N 个
     */
    public int fib(int N) {
        int a = 0, b = 1;
        int c;
        while (N > 0) {
            c = a;
            a = b;
            b = a + c;
            N--;
        }
        return a;
    }
}