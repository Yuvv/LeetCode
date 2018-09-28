class Solution {
    public int mySqrt(int x) {
        // 牛顿法求解
        // f(x) = x^2 - k
        // x(n+1) = x(n) - f(xn)/f'(xn)
        double xn = x / 2.0;
        double d;  // distabce
        do {
            d = Math.abs((xn * xn - x) / (2 * xn));
            xn -= (xn * xn - x) / (2 * xn);
        } while (d >= 0.1);
        
        return (int)xn;
    }
}