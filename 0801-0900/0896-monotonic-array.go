/**
 * 判断一个数组是否单调
 * https://leetcode.com/problems/monotonic-array/description/
 */
 func isMonotonic(A []int) bool {
    aLen := len(A)
	if aLen <= 1 {
		return true
	}
	var sign int8
	var distance int
	lastVar := A[0]
	for i := 1; i < aLen; i++ {
		distance = A[i] - lastVar
		if sign == 0 && distance != 0 {
			if distance < 0 {
				sign = -1
			} else {
				sign = 1
			}
		}
		if sign > 0 && distance < 0 {
			return false
		}
		if sign < 0 && distance > 0 {
			return false
		}
		lastVar = A[i]
	}
	return true
}