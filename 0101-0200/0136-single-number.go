// 找出数组中的单身狗
// https://leetcode.com/problems/single-number/description/
func singleNumber(nums []int) int {
    r := 0
	for i := 0; i < len(nums); i++ {
		r ^= nums[i]
	}
	return r
}