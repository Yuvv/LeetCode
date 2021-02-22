package main

import "fmt"

func rFindTargetSumWays(nums []int, numLimit int, target int) int {
	if numLimit == 0 {
		total := 0
		// total = 2 if target == -target
		if nums[numLimit] == target {
			total++
		}
		if nums[numLimit] == -target {
			total++
		}
		return total
	}

	// can be optimized by storing results
	return rFindTargetSumWays(nums, numLimit-1, target-nums[numLimit]) + rFindTargetSumWays(nums, numLimit-1, target+nums[numLimit])
}

func findTargetSumWays(nums []int, S int) int {
	nLen := len(nums)
	return rFindTargetSumWays(nums, nLen-1, S)
}

func main() {
	// 5 expected
	fmt.Println(findTargetSumWays([]int{1, 1, 1, 1, 1}, 3))
	// 256 expected
	fmt.Println(findTargetSumWays([]int{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1))
}
