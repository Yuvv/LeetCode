/**
 * 将一个数组偶数移到右边，奇数移到左边，任意顺序均可
 * https://leetcode.com/problems/sort-array-by-parity/description/
 */
func sortArrayByParity(A []int) []int {
    begin := 0
	end := len(A) - 1
	var tmp int
	for end > begin {
		for A[begin] % 2 == 0 && begin < end {
			begin++
		}
		for A[end] % 2 == 1 && end > begin {
			end--
		}
		if end <= begin {
			break
		}
		tmp = A[begin]
		A[begin] = A[end]
		A[end] = tmp
		begin++
		end--
	}
	return A
}