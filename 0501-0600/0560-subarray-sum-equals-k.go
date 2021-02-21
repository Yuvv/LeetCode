package main

import "fmt"

func subarraySum(nums []int, k int) int {
	// cumSum -> subset count
	cumSumMap := make(map[int]int)
	cumSum := 0
	totalCount := 0
	arrLen := len(nums)

	// get cum sum
	cumSumMap[0] = 1
	for i := 0; i < arrLen; i++ {
		cumSum += nums[i]
		if ssCount, ok := cumSumMap[cumSum-k]; ok && ssCount > 0 {
			totalCount += ssCount
		}
		cumSumMap[cumSum] = cumSumMap[cumSum] + 1

	}
	return totalCount
}

func main() {
	// 2 expected
	fmt.Println(subarraySum([]int{1, 1, 1}, 2))
	// 2 expected
	fmt.Println(subarraySum([]int{1, 2, 3}, 3))
	// 5 expected
	fmt.Println(subarraySum([]int{1, 2, 3, 4, -1, -2, 5, -3}, 3))
}
