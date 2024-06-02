/**
 * 翻转字符串
 * https://leetcode.com/problems/reverse-string/description/
 */
func reverseString_old(s string) string {
	sLen := len(s)
	result := make([]uint8, sLen)
	for i := 1; i <= sLen; i++ {
		result[i-1] = s[sLen-i]
	}

	return string(result)
}

// 官方函数签名改了
func reverseString(s []byte) []byte {
	j := len(s) - 1
	for i := 0; i < j; i++ {
		s[i], s[j] = s[j], s[i]
		j--
	}
	return s
}