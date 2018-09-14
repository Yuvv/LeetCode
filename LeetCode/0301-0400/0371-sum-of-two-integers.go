/**
 * 不用 + 或 - 实现两个数的加法（位运算）
 * https://leetcode.com/problems/sum-of-two-integers/description/
 */

func getSum(a int, b int) int {
	sum := a ^ b
	carry := a & b
	for carry != 0 {
		carry <<= 1
		a = sum    // temp value
		sum ^= carry
		carry &= a
	}
	return sum
}