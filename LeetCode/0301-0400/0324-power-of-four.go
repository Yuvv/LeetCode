// x^2n - 1 = (x^2)^n - 1 = (x^2 - 1)(x^2 + 1)
// 4^n = (3 + 1)^n = \sum_n^k{3^k}
func isPowerOfFour(num int) bool {
    return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0
}