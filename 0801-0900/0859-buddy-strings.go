// 判断字符串 A 能够仅通过交换两个字符一次变成 B
func buddyStrings(A string, B string) bool {
    aLen, bLen := len(A), len(B)
	if aLen < 2 || aLen != bLen {
		return false
	}
	m := make(map[byte]bool)  // 记录字符集合
	idx := 0
	index := [2]int {0, 1}    // 不同的字符的索引位置
	for i := 0; i < aLen; i++ {
		m[A[i]] = true
		if idx >= 2 {
			return false
		}
		if A[i] != B[i] {
			index[idx] = i
			idx++
		}
	}
	if idx == 2 {
		return A[index[0]] == B[index[1]] && A[index[1]] == B[index[0]]
	}
	return idx == 0 && len(m) < aLen  // a b 相等时存在重复字符即可
}