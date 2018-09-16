/**
 * 翻转字符串
 * https://leetcode.com/problems/reverse-string/description/
 */
func reverseString(s string) string {
    sLen := len(s)
	result := make([]uint8, sLen)
	for i := 1; i <= sLen; i++ {
		result[i - 1] = s[sLen-i]
	}

	return string(result)
}