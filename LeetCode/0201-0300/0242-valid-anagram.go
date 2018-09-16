/**
 * 判断两个字符串通过一定交换后是否相等
 * https://leetcode.com/problems/valid-anagram/description/
 */
func isAnagram(s string, t string) bool {
    sLen := len(s)
	tLen := len(t)
	if sLen != tLen {
		return false
	}
	sArr := make([]int, sLen)
	tArr := make([]int, tLen)
	for i := 0; i < sLen; i++ {
		sArr[i] = int(s[i])
		tArr[i] = int(t[i])
	}
	sort.Ints(sArr)
	sort.Ints(tArr)

	for i := 0; i < sLen; i++ {
		if sArr[i] != tArr[i] {
			return false
		}
	}
	return true
}