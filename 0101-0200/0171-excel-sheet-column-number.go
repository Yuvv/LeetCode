const BASE = 26

// excel 列数计算
// https://leetcode.com/problems/excel-sheet-column-number/description/
func  titleToNumber(s string) int {
	sLen := len(s)
    result := 0
    for i := 0; i < sLen; i++ {
		result = result * BASE + int(s[i] - '@')
    }
    return result
}