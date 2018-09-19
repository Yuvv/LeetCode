// 罗马数字转换为整数
// https://leetcode.com/problems/roman-to-integer/
func romanToInt(s string) int {
	result := 0
	var lastChar uint8
	for i := 0; i < len(s); i++ {
		switch s[i] {
		case 'I':
			result += 1
		case 'V':
			if lastChar == 'I' {
				result += 3 // +4 - 1
			} else {
				result += 5
			}
		case 'X':
			if lastChar == 'I' {
				result += 8 // +9 - 1
			} else {
				result += 10
			}
		case 'L':
			if lastChar == 'X' {
				result += 30 // +40 - 10
			} else {
				result += 50
			}
		case 'C':
			if lastChar == 'X' {
				result += 80 // +90 - 10
			} else {
				result += 100
			}
		case 'D':
			if lastChar == 'C' {
				result += 300 // +400 - 100
			} else {
				result += 500
			}
		case 'M':
			if lastChar == 'C' {
				result += 800 // +900 - 100
			} else {
				result += 1000
			}
		default:
			break
		}
		lastChar = s[i]
	}

	return result
}