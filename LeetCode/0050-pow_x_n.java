class Solution {
    public double myPow(double x, int n) {
        long m = n > 0 ? n : -(long)n;
        double ans = 1.0;
        while (m != 0) {
            if ((m & 1) == 1)
                ans *= x;
            x *= x;
            m >>= 1;
        }
        return n >= 0 ? ans : 1 / ans;
        // 1.00001， 123456 出错，精度问题
//        if (n == 0) {
//             return 1D;
//         }
//         boolean minus = false;
//         if (n < 0) {
//             minus = true;
//             n = -n;
//         }
//         HashMap<Integer, Double> map = new HashMap<>();
//         map.put(1, x);
//         int r = 2;
//         while (r <= n) {
//             x *= x;
//             map.put(r, x);
//             r *= 2;
//         }
//         n = n - r / 2;
//         r = n % 2 == 1 ? 1 : 2;
//         while (n > 0) {
//             if (map.containsKey(n)) {
//                 x *= map.get(n);
//                 return minus ? 1 / x : x;
//             }
//             x *= map.get(r);
//             n -= r;
//             r *= 2;
//         }

//         return minus ? 1 / x : x;
    }
}