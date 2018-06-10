// https://leetcode.com/problems/reverse-integer/description/

class Solution {
    public int reverse(int x) {
        boolean minus = false;
        if (x < 0) {
            minus = true;
            if (x == - x) {
                return 0;  // -2147483648
            }
            x = -x;
        }

        long r = 0;
        do {
            r = r * 10 + x % 10;
            x /= 10;
        } while (x > 0);
        
        if (r > Integer.MAX_VALUE) {  // 溢出
            return 0;
        }

        if (minus) {
            r = -r;
        }
        
        return (int)r;
    }
}