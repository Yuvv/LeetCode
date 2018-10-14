var DS_MAP = map[uint8]string{
	'2': "abc",
	'3': "def",
	'4': "ghi",
	'5': "jkl",
	'6': "mno",
	'7': "pqrs",
	'8': "tuv",
	'9': "wxyz",
}
// 按照数字进位方法逐个获取即可
func letterCombinations(digits string) []string {
	sLen := len(digits)
	indexes := make([]int, sLen)
	rLen := 1
	for i := 0; i < sLen; i++ {
		rLen *= len(DS_MAP[digits[i]])
	}
	if sLen == 0 {
		rLen = 0
	}
	results := make([]string, rLen)
	eachChars := make([]uint8, sLen)
	var pos, carry int
	for i := 0; i < rLen; i++ {
		for j := 0; j < sLen; j++ {
			eachChars[j] = DS_MAP[digits[j]][indexes[j]]
		}
		results[i] = string(eachChars)

		pos = sLen - 1
		carry = 1
		for pos >= 0 && carry == 1 {
			indexes[pos] += carry
			if indexes[pos] >= len(DS_MAP[digits[pos]]) {
				carry = 1
				indexes[pos] = 0
				pos--
			} else {
				carry = 0
			}
		}
	}

	return results
}