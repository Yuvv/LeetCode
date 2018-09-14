/**
 * 按位取反一个数
 * https://leetcode.com/problems/number-complement/description/
 */
func findComplement(num int) int {
    result := 0
	var pos uint = 0
	var bit int
	for num > 0 {
		bit = 1 - (num & 1)
		if bit > 0 {
			result = (bit << pos) + result
		}
 		num >>= 1
 		pos++
	}
	return result
}