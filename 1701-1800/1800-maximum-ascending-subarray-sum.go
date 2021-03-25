package main

import "fmt"

func maxAscendingSum(nums []int) int {
	maxSum := nums[0]
	nLen := len(nums)
	cur, curSum := 1, nums[0]
	for cur < nLen {
		if nums[cur] > nums[cur-1] {
			curSum += nums[cur]
		} else {
			curSum = nums[cur]
		}
		if curSum > maxSum {
			maxSum = curSum
		}
		cur++
	}
	return maxSum
}

func main() {
	// 65
	fmt.Println(maxAscendingSum([]int{10, 20, 30, 5, 10, 50}))
	// 150
	fmt.Println(maxAscendingSum([]int{10, 20, 30, 40, 50}))
	// 33
	fmt.Println(maxAscendingSum([]int{12, 17, 15, 13, 10, 11, 12}))
	// 100
	fmt.Println(maxAscendingSum([]int{100, 10, 1}))
}
