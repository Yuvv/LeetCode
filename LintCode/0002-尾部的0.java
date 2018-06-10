class Solution {
    /*
     * param n: An desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // 每一个 5 带来一个0，而25可以拆成 5*5，依此类推
        long sum = 0;
        long base = 5;
        long k = n / base;
        while (k > 0) {
            sum += k;
            base *= 5L;
            k = n / base;
        }
        return sum;
    }
};