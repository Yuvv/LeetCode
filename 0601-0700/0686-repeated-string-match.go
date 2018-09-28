func indexOf(a, b string) int {
	aLen, bLen := len(a), len(b)
	if bLen <= 0 {
		return -1
	}
	for i := 0; i <= aLen-bLen; i++ {
		j := 0
		if a[i] == b[j] {
			k := i
			eq := true
			for j < bLen {
				if a[k] != b[j] {
					eq = false
					break
				}
				k++
				j++
			}
			if eq {
				return i
			}
		}
	}
	return -1
}

// 判断 A 重复多少次之后使得 B 是 A 的子串
// https://leetcode.com/problems/repeated-string-match/description/
func repeatedStringMatch(A string, B string) int {
	times := len(B) / len(A)
	if len(B)%len(A) > 0 {
		times += 1
	}
	a := A
	for i := 1; i < times; i++ {
		A += a
	}
	idx := indexOf(A, B)
	if idx != -1 {
		return times
	}
	A += a
	idx = indexOf(A, B)
	if idx != -1 {
		return times + 1
	}
	return -1
}