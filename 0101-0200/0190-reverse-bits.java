public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0, count = 0;
        int remainder;
        while (n > 0) {
            remainder = n % 2;
            n >>= 1;
            count++;
            result = (result << 1) + remainder;
        }
        return result << (32 - count);
        // 垃圾，又搞 2147483648 这种 case
        // return Integer.reverse(n);
    }
}