class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // 暴力解法
        // int sum = 0;
        // int y, s;
        // for(int i=0; i<=n; i++) {
        //     s = i;
        //     do {
        //         y = s % 10;
        //         s = s / 10;
        //         if (y == k) {
        //             sum++;
        //         }
        //     } while(s > 0);
        // }
        // return sum;
        
        // 固定某一位不变，那么只要看高位有多少种情况即可
        int sum = 0;
        int base = 1;
        int high, cur;
        do {
            cur = n / base % 10;
            high = n / base / 10;
            if (cur < k) {
                sum += high * base;
            } else if (cur == k) {
                sum += high * base + n % base + 1;
            } else if(!(high == 0 && k == 0 && base > 1)) {  // 排除高位为零搜索数为 0，但只有一位数时又可以搜索的情况
                sum += (high + 1) * base;
            }
            base *= 10;
        } while (high > 0);
        
        return sum;
    }
};