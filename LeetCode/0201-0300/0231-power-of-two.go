/**
 * 判断一个数是否是 2 ^ n
 * https://leetcode.com/problems/power-of-two/description/
 */
func isPowerOfTwo(n int) bool {
    if n == 0 {
        return false
    }
    return (n & (n - 1)) == 0
}