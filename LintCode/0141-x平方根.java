public class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        
        if (x < 2) {
            return x;
        }

        // 牛顿法
        double xn = x / 2;
        double xn1 = xn - (xn * xn - x) / 2 / xn;

        while (Math.abs(xn1 - xn) >= 0.1) {
            xn = xn1;
            xn1 = xn - (xn * xn - x) / 2 / xn;
        }

        return (int)xn;
    }
}