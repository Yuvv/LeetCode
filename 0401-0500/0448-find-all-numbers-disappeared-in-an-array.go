func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}

/**
 * 找出长为 n 数组中缺失值
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 */
func findDisappearedNumbers(nums []int) []int {
	numLen := len(nums)

	for i := 0; i < numLen; i++ {
		j := abs(nums[i]) - 1
		nums[j] = -abs(nums[j])
	}

	var resultArr []int
	for i := 0; i < numLen; i++ {
		if nums[i] > 0 {
			resultArr = append(resultArr, i + 1)
		}
	}
	return resultArr
}