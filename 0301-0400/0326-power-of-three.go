// n 无限大除 3 求余是最好方法
func isPowerOfThree(n int) bool {
    for n % 3 == 0 && n > 0 {
        n /= 3
    }
    return n == 1
}